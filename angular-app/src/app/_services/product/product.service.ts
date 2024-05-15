import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AttributeValue } from 'src/app/_model/AttributeValue';
import { Product } from 'src/app/_model/Product';
import { Value } from 'src/app/_model/Value';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  PATH_OF_API = 'http://localhost:9090/api/products';

  constructor(private http: HttpClient) { }

  public insert(product: Product){
    return this.http.post<Product>(this.PATH_OF_API, product);
  }

  public insertValue(value: Value){
    return this.http.post<Value>('http://localhost:9000/api/values', value);
  }

  public findAll(){
    return this.http.get<Product[]>(this.PATH_OF_API);
  }

  public findById(id: number){
    return this.http.get<Product>(this.PATH_OF_API+'/'+id);
  }

  public findAttributeValues(id: number){
    return this.http.get<AttributeValue[]>(this.PATH_OF_API+'/attributes-values/'+id);
  }




}
