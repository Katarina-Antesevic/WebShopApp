import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './_components/home/home.component';
import { HeaderComponent } from './_components/header/header.component';
import { LoginComponent } from './_components/login/login.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http'
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button'
import { MatFormFieldModule, MatLabel } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { RegisterComponent } from './_components/register/register.component';
import { MatSnackBarModule  } from '@angular/material/snack-bar';
import { DatePipe } from '@angular/common';
import { CommonModule } from '@angular/common';
import { HeaderDefaultComponent } from './_components/header-default/header-default.component';
import { ActivateComponent } from './_components/activate/activate.component';
import { MessageComponent } from './_components/message/message.component';
import { ProfileComponent } from './_components/profile/profile.component';
import { InfoUpdateComponent } from './_components/info-update/info-update.component';
import { PassUpdateComponent } from './_components/pass-update/pass-update.component';
import { OffersComponent } from './_components/offers/offers.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { OfferDetailsComponent } from './_components/offer-details/offer-details.component';
import { UserOffersComponent } from './_components/user-offers/user-offers.component';
import { PurchaseComponent } from './_components/purchase/purchase.component';
import { UserPurchasesComponent } from './_components/user-purchases/user-purchases.component';
import { NewOfferComponent } from './_components/new-offer/new-offer.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    RegisterComponent,
    LoginComponent,
    ActivateComponent,
    MessageComponent,
    HeaderDefaultComponent,
    ProfileComponent,
    InfoUpdateComponent,
    PassUpdateComponent,
    OffersComponent,
    OfferDetailsComponent,
    UserOffersComponent,
    PurchaseComponent,
    UserPurchasesComponent,
    NewOfferComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    MatSnackBarModule,
    CommonModule,
    MatPaginatorModule 

  ],
  providers: [DatePipe],
  bootstrap : [AppComponent]
})
export class AppModule { 
  
}
