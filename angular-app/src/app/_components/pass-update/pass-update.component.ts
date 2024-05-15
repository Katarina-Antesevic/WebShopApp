import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthenticationService } from 'src/app/_auth/authentication.service';
import { User } from 'src/app/_model/User';
import { UserService } from 'src/app/_services/user/user.service';

@Component({
  selector: 'app-pass-update',
  templateUrl: './pass-update.component.html',
  styleUrls: ['./pass-update.component.css']
})
export class PassUpdateComponent implements OnInit {

  public user: User | null = null;
  public form: FormGroup = new FormGroup({});

  constructor(private authenticationService: AuthenticationService, private formBuilder: FormBuilder, private userService: UserService, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    if (this.authenticationService.loggedUser) {
      this.user = this.authenticationService.loggedUser;

      this.form = this.formBuilder.group({
        password: [null, Validators.required],
        passwordRepeated: [null, Validators.required]
      });
    }
  }

  public passUpdate() {
    let password = this.form.value.password;
    let passwordRepeated = this.form.value.passwordRepeated;

    if (password != passwordRepeated) {
      this.snackBar.open("Unesene lozinke se ne poklapaju!", '', {
        horizontalPosition: "center",
        duration: 3000,
      });
    }
    else {
      if (this.user) {
        let updateUser = this.user;
        updateUser.password = password;
        this.userService.update(updateUser).subscribe({
          next: (response: User)=>{
            this.authenticationService.loggedUser=response;
            this.user=response;
            this.snackBar.open("Uspjesno ste promijenili lozinku!", '', {
              horizontalPosition: "center",
              duration: 3000,
            });
            this.form.reset();

          },
          error:()=>{
            this.snackBar.open("Doslo je do greske prilikom promjene lozinke!",'', {
              horizontalPosition: "center",
              duration: 3000,
            });
            this.form.reset();
          }
        })
      }
    }

  }

}
