import { HttpClient } from '@angular/common/http';
import { ThisReceiver } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Offer } from 'src/app/_model/Offer';

@Injectable({
  providedIn: 'root'
})
export class OfferService {

  PATH_OF_API = 'http://localhost:9090/api/offers';
  private dataSource = new BehaviorSubject<any>({});
  public offer = this.dataSource.asObservable();

  constructor(private http: HttpClient) { }

  setOffer(o: Offer) {
    this.dataSource.next(o);
  }

  public insert(offer: Offer) {
    return this.http.post<Offer>(this.PATH_OF_API, offer);
  }

  public update(offer: Offer) {
    return this.http.put<Offer>(this.PATH_OF_API + '/' + offer.id, offer);
  }

  public findAll() {
    return this.http.get<Offer[]>(this.PATH_OF_API + '/existing');
  }

  public findByIdUser(id: number) {
    return this.http.get<Offer[]>(this.PATH_OF_API+'/idUser/'+id);
  }

  public findByIdCategory(id: number){
    return this.http.get<Offer[]>(this.PATH_OF_API+'/idCategory/'+id);
  }

}
