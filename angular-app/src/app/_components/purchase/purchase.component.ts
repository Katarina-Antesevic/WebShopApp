import { DatePipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/_auth/authentication.service';
import { Offer } from 'src/app/_model/Offer';
import { PaymentType } from 'src/app/_model/PaymentType';
import { Purchase } from 'src/app/_model/Purchase';
import { User } from 'src/app/_model/User';
import { OfferService } from 'src/app/_services/offer/offer.service';
import { PaymentTypeService } from 'src/app/_services/payment-type/payment-type.service';
import { PurchaseService } from 'src/app/_services/purchase/purchase.service';

@Component({
  selector: 'app-purchase',
  templateUrl: './purchase.component.html',
  styleUrls: ['./purchase.component.css']
})
export class PurchaseComponent implements OnInit {

  public offer: Offer | null = null;
  public user: User | null = null;
  public paymentTypes: PaymentType[] = [];

  public form: FormGroup = new FormGroup({});

  public userPaymentType: string = "";
  public cardPayment: boolean = false;

  constructor(private authenticationService: AuthenticationService, private router: Router,
    private paymentTypeService: PaymentTypeService, private formBuilder: FormBuilder,
    private datePipe: DatePipe, private snackBar: MatSnackBar,
    private purchaseService: PurchaseService, private offerService: OfferService) { }

  ngOnInit(): void {
    if (this.authenticationService.loggedUser) {
      this.user = this.authenticationService.loggedUser;
    }
    this.offerService.offer.subscribe(
      (response: Offer) => {
        this.offer = response;
      }
    );

    this.paymentTypeService.findAll().subscribe(
      (response) => this.paymentTypes = response
    )

    this.form = this.formBuilder.group({
      product: [this.offer?.product.name],
      price: [this.offer?.product.price],
      cardNumber: [null],
      paymentType: new FormControl()
    });

  }

  selectPaymentType(event: any) {
    this.userPaymentType = event.target.value;
    this.cardPayment = event.target.value === 'Placanje karticom';
  }

  purchaseProduct() {
    let paymentType = this.paymentTypes.find(t => t.name === this.userPaymentType);
    let cardNumber = this.form.value.cardNumber;
    let dateTime = this.datePipe.transform(new Date(), 'dd/MM/yyyy hh:mm:ss');
    if (this.cardPayment && cardNumber == null) {
      this.snackBar.open("Morate unijeti broj Vase kartice!", '', {
        horizontalPosition: "center",
        duration: 3000,
      });
    }
    else {
      if (dateTime && paymentType && this.offer && this.user) {
        let purchase = new Purchase(null, cardNumber, dateTime, this.offer, paymentType, this.user);

        this.purchaseService.insert(purchase).subscribe({
          next: (response: Purchase) => {
            let offerUpdated = response.offer;
            offerUpdated.isActive = false;

            this.offerService.update(offerUpdated).subscribe({
              next: () => {
                this.snackBar.open("Kupovina proizvoda je uspjesna!", '', {
                  horizontalPosition: "center",
                  duration: 3000,
                });
                this.router.navigate(['/']);
              },
              error: () => {
                this.snackBar.open("Kupovina proizvoda nije uspjesna!", '', {
                  horizontalPosition: "center",
                  duration: 3000,
                });
              }
            })
          }
        })
      }
    }
  }


}
