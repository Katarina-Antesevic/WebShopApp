import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/_auth/authentication.service';
import { User } from 'src/app/_model/User';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit{

  public user: User | null=null;

  constructor(private authenticationService: AuthenticationService){}

  ngOnInit(): void {

    if(this.authenticationService.loggedUser){
      this.user=this.authenticationService.loggedUser;
    }
  }



}
