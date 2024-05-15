import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './_components/home/home.component';
import { LoginComponent } from './_components/login/login.component';
import { RegisterComponent } from './_components/register/register.component';
import { ActivationGuardService } from './_auth/activation-guard.service';
import { GuardService } from './_auth/guard.service';
import { MessageComponent } from './_components/message/message.component';
import { ActivateComponent } from './_components/activate/activate.component';
import { ProfileComponent } from './_components/profile/profile.component';
import { InfoUpdateComponent } from './_components/info-update/info-update.component';
import { PassUpdateComponent } from './_components/pass-update/pass-update.component';
import { OfferDetailsComponent } from './_components/offer-details/offer-details.component';
import { UserOffersComponent } from './_components/user-offers/user-offers.component';
import { PurchaseComponent } from './_components/purchase/purchase.component';
import { UserPurchasesComponent } from './_components/user-purchases/user-purchases.component';
import { NewOfferComponent } from './_components/new-offer/new-offer.component';

//za kreiranje ruta //alt+shift+f - formatiranje koda :D
const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'activate', component: ActivateComponent, canActivate: [ActivationGuardService] },
  { path: 'login', component: LoginComponent },
  { path: 'custommer-service', component: MessageComponent, canActivate: [GuardService] },
  { path: 'info', component: ProfileComponent, canActivate: [GuardService] },
  { path: 'info-update', component: InfoUpdateComponent, canActivate: [GuardService] },
  { path: 'password-update', component: PassUpdateComponent, canActivate: [GuardService] },
  { path: 'offer-details', component: OfferDetailsComponent },
  { path: 'user-offers', component: UserOffersComponent, canActivate: [GuardService] },
  { path: 'purchase', component: PurchaseComponent, canActivate: [GuardService] },
  { path: 'user-purchases', component: UserPurchasesComponent, canActivate: [GuardService] },
  { path: 'new-offer', component: NewOfferComponent, canActivate: [GuardService] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { enableTracing: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
