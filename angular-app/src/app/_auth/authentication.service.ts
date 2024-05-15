import { Injectable } from '@angular/core';
import { User } from '../_model/User';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from '../_services/user/user.service';
import { MailService } from '../_services/mail/mail.service';
import { Mail } from '../_model/Mail';
import { HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  public users: User[] = [];
  public loggedUser: User | null = null;
  public isActivated: boolean = false;
  public isLoggedIn: boolean = false;

  constructor(private router: Router, private snackBar: MatSnackBar, private userService: UserService, private mailService: MailService) {

  }

  public createPIN(){
    let pin="";
    for(let i=0;i<4;i++){
      pin+=Math.floor(Math.random()*10);
    }
    return pin;
  }

  public logout(){
    this.loggedUser=null;
    this.isActivated=false;
    this.isLoggedIn=false;
    this.router.navigate(['/']);
  }

  public createNewPin(){
    let newPin = this.createPIN();
    if(this.loggedUser){ //prosla aktivacija nije dobra bila
      this.loggedUser.pin=newPin;
      this.userService.update(this.loggedUser).subscribe({
        next: (response: User) => {
          this.mailService.sendMail(new Mail(response.mail, response.pin)).subscribe(); //posalji novi mail o pinu
          this.loggedUser=response;
          this.snackBar.open("Da biste aktivirali nalog, unesite novi PIN!",'', {
            horizontalPosition: "center",
            duration: 3000,
          });
          this.router.navigate(['/activate']);
        },
        error: () => {
          this.snackBar.open("Doslo je do greske. Pokusajte ponovo!",'', {
            horizontalPosition: "center",
            duration: 3000,
          });
          this.router.navigate(['/login']);
        }
      })

    }else{
      this.router.navigate(['/']);
    }
  }



  public login(username: string, password: string){
    this.userService.findByUsername(username).subscribe({
      next: (response: User) => {
        if(response.password == password){
          this.loggedUser=response;
          this.isLoggedIn=true;
          this.isActivated=response.isActivated;

          if(response.isActivated){
            this.router.navigate(['/']);
          }

          else{
            this.createNewPin();
          }
        }else{
          this.snackBar.open("Niste unijeli ispravnu lozinku!",'', {
            horizontalPosition: "center",
            duration: 3000,
          });
        }
        
      },
      error: (response: HttpErrorResponse) => {
        if(response.status===404){
          this.snackBar.open("Niste unijeli ispravno korisnicko ime!",'', {
            horizontalPosition: "center",
            duration: 3000,
          });
        }else{
          this.snackBar.open("Doslo je do greske. Pokusajte ponovo!",'', {
            horizontalPosition: "center",
            duration: 3000,
          });
        }

      }
    })
  }

  public register(user: User){
    this.userService.insert(user).subscribe({
      next: (response: User) =>{
        this.loggedUser=response;
        this.isActivated=false;
        this.isLoggedIn=true;
        this.mailService.sendMail(new Mail(response.mail, response.pin)).subscribe();

        this.snackBar.open("Uspjesno ste kreirali nalog!",'', {
          horizontalPosition: "center",
          duration: 3000,
        });
        this.router.navigate(['/activate']);
      },
      error: (response: HttpErrorResponse) =>{
        if(response.status===409){
          this.snackBar.open("Zeljeno korisnicko ime je zauzeto!",'', {
            horizontalPosition: "center",
            duration: 3000,
          });
        }else{
          this.snackBar.open("Doslo je do greske. Pokusajte ponovo!",'', {
            horizontalPosition: "center",
            duration: 3000,
          });
        }
        
      }
    })
  }

  public activate(pin: string) {
    if(this.loggedUser && this.loggedUser.pin==pin){
      this.loggedUser.isActivated=true;
      this.userService.update(this.loggedUser).subscribe({
        next: (response: User) => {
          this.loggedUser=response;
          this.isActivated=true;
          this.snackBar.open("Uspjesno ste aktivirali Vas nalog!",'', {
            horizontalPosition: "center",
            duration: 3000,
          });
          this.router.navigate(['/']);
        },
        error: (response: HttpErrorResponse) =>{
          this.snackBar.open("Doslo je do greske!",'', {
            horizontalPosition: "center",
            duration: 3000,
          });
        }
      })
    }
    else if(this.loggedUser && this.loggedUser.pin!=pin){
      this.snackBar.open("Niste unijeli ispravan PIN!",'', {
        horizontalPosition: "center",
        duration: 3000,
      });
    }
    else{
      this.router.navigate(['/']);
    }
  }


}
