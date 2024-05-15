import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class ActivationGuardService implements CanActivate{

  constructor(private authenticationService: AuthenticationService, private router:Router) { }

  canActivate(): boolean{
    if(this.authenticationService.isLoggedIn && !this.authenticationService.isActivated){
      return true;
    }else{
      this.router.navigate(['/']);
      return false;
    }
  }


}
