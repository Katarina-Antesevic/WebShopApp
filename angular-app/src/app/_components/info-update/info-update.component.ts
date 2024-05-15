import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthenticationService } from 'src/app/_auth/authentication.service';
import { User } from 'src/app/_model/User';
import { UserService } from 'src/app/_services/user/user.service';

@Component({
  selector: 'app-info-update',
  templateUrl: './info-update.component.html',
  styleUrls: ['./info-update.component.css']
})
export class InfoUpdateComponent implements OnInit {

  public user: User | null = null;
  public form: FormGroup = new FormGroup({});

  constructor(private authenticationService: AuthenticationService, private formBuilder: FormBuilder, private userService: UserService, private snackBar: MatSnackBar){}

  ngOnInit(): void {
    if(this.authenticationService.loggedUser){
      this.user=this.authenticationService.loggedUser;

      this.form=this.formBuilder.group({
        firstName: [this.user.firstName, Validators.required],
        lastName: [this.user.lastName, Validators.required],
        city: [this.user.city, Validators.required],
        mail: [this.user.mail, Validators.required],
        avatar: [this.user.avatar, Validators.required]
      })
    }
  }

  public infoUpdate(){
    let firstName: string = this.form.value.firstName;
    let lastName: string = this.form.value.lastName;
    let mail: string = this.form.value.mail;
    let city: string = this.form.value.city;
    let avatar: string = this.form.value.avatar;

    if(this.user){
      let updateUser = new User(this.user.id, firstName, lastName, this.user.username, this.user.password, city, mail, avatar, this.user.pin,this.user.isActivated);
      this.userService.update(updateUser).subscribe({
        next: (response: User)=>{
          this.authenticationService.loggedUser=response;
          this.user=response;
          this.snackBar.open("Uspjesno ste promijenili vase posatke!",'', {
            horizontalPosition: "center",
            duration: 3000,
          });
        },
        error: () =>{
          this.snackBar.open("Doslo je do greske prilikom promjene podataka!",'', {
            horizontalPosition: "center",
            duration: 3000,
          });
        }
      })

    }

  }

}
