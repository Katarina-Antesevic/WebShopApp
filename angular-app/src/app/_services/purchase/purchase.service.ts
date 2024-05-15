import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Purchase } from 'src/app/_model/Purchase';

@Injectable({
  providedIn: 'root'
})
export class PurchaseService {

  PATH_OF_API = 'http://localhost:9090/api/purchases';

  constructor(private http: HttpClient) { }

  public insert(purchase: Purchase){
    return this.http.post<Purchase>(this.PATH_OF_API, purchase);
  }

  public findAll(){
    return this.http.get<Purchase[]>(this.PATH_OF_API);
  }

  public findByIdUser(id: number){
    return this.http.get<Purchase[]>(this.PATH_OF_API+'/idUser/'+id);
  }
}
