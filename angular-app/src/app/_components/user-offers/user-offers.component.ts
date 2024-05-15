import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthenticationService } from 'src/app/_auth/authentication.service';
import { Offer } from 'src/app/_model/Offer';
import { User } from 'src/app/_model/User';
import { OfferService } from 'src/app/_services/offer/offer.service';

@Component({
  selector: 'app-user-offers',
  templateUrl: './user-offers.component.html',
  styleUrls: ['./user-offers.component.css']
})
export class UserOffersComponent implements OnInit{
  
  public offers: Offer[] = [];
  public user: User | null=null;
  
  constructor(private authenticationService: AuthenticationService, private offerService: OfferService,
    private snackBar: MatSnackBar){}

  ngOnInit(): void {
    this.findUserOffers();
  }

  private findUserOffers(){
    if(this.authenticationService.loggedUser && this.authenticationService.loggedUser.id){
      this.user = this.authenticationService.loggedUser;
      this.offerService.findByIdUser(this.authenticationService.loggedUser.id).subscribe(
        (response)=>this.offers=response
      )
    }
  }


}
