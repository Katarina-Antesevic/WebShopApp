import { Component, OnInit } from '@angular/core';
import { Form, FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/_auth/authentication.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { User } from 'src/app/_model/User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {  

  public form: FormGroup = new FormGroup({});

  constructor(private authenticationService: AuthenticationService,
    private formBuilder: FormBuilder, private snackBar: MatSnackBar) { }

    
    ngOnInit(): void {
      this.form = this.formBuilder.group({
        firstName: [null, Validators.required],
        lastName: [null, Validators.required],
        username: [null, Validators.required],
        password: [null, Validators.required],
        passwordRepeat: [null, Validators.required],
        city: [null, Validators.required],
        mail: [null, Validators.required],
        avatar: [null]
      })
    }

    public register(){
      let firstName: string = this.form.value.firstName;
      let lastName: string = this.form.value.lastName;
      let username: string = this.form.value.username;
      let password: string = this.form.value.password;
      let passwordRepeat: string = this.form.value.passwordRepeat;
      let city: string = this.form.value.city;
      let mail: string = this.form.value.mail;
      let avatar: string = this.form.value.avatar;

      if(password != passwordRepeat){

        this.snackBar.open("Unesene lozinke se ne poklapaju!",'', {
          horizontalPosition: "center",
          duration: 3000,
        });
      }else{
        let user = new User(null, firstName, lastName, username, password, city, mail, avatar, this.authenticationService.createPIN(), false);
        this.authenticationService.register(user);
      }
    }


}
