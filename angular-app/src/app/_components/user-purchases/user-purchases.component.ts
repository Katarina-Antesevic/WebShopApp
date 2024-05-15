import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/_auth/authentication.service';
import { Purchase } from 'src/app/_model/Purchase';
import { User } from 'src/app/_model/User';
import { PurchaseService } from 'src/app/_services/purchase/purchase.service';

@Component({
  selector: 'app-user-purchases',
  templateUrl: './user-purchases.component.html',
  styleUrls: ['./user-purchases.component.css']
})
export class UserPurchasesComponent implements OnInit{

  public purchases: Purchase[] = [];
  public user: User | null = null;

  constructor(private authenticationService: AuthenticationService, private purchaseService: PurchaseService) { }

  ngOnInit(): void {
    this.findUserPurchases();
  }

  findUserPurchases() {
    if (this.authenticationService.loggedUser && this.authenticationService.loggedUser.id) {
      this.user = this.authenticationService.loggedUser;
      this.purchaseService.findByIdUser(this.authenticationService.loggedUser.id).subscribe(
        (response) => {
          this.purchases = response;
        }
      )
    }
  }

}
