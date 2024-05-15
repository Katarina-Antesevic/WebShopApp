import { Injectable } from '@angular/core';
import { CanActivate, Route, Router } from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class GuardService implements CanActivate {

  constructor(private authenticationService: AuthenticationService, private router: Router) { }

  canActivate(): boolean {
    if (this.authenticationService.loggedUser && this.authenticationService.isActivated) {
      return true;
    }
    else if (this.authenticationService.isLoggedIn && !this.authenticationService.isActivated) {
      this.router.navigate(['/activate']);
      return false;
    }
    else {
      this.router.navigate(['/']);
      return false;
    }
  }

}
