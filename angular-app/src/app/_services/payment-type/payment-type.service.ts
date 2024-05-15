import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PaymentType } from 'src/app/_model/PaymentType';

@Injectable({
  providedIn: 'root'
})
export class PaymentTypeService {

  PATH_OF_API = 'http://localhost:9090/api/payment-types';

  constructor(private http: HttpClient) { }

  public findAll(){
    return this.http.get<PaymentType[]>(this.PATH_OF_API);
  }
}
