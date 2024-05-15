import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/_auth/authentication.service';

@Component({
  selector: 'app-activate',
  templateUrl: './activate.component.html',
  styleUrls: ['./activate.component.css']
})
export class ActivateComponent implements OnInit{

  public form: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder,
    private authenticationService: AuthenticationService){}

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      pin: [null, Validators.required]
    });
  }
  
  public activate(){
    let pin = this.form.value.pin;
    this.authenticationService.activate(pin);
  }
  

}
