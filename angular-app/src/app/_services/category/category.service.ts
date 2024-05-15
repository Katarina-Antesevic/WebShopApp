import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Attribute } from 'src/app/_model/Attribute';
import { Category } from 'src/app/_model/Category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  PATH_OF_API = 'http://localhost:9090/api/categories';

  constructor(private http: HttpClient) { }

  public findAll(){
    return this.http.get<Category[]>(this.PATH_OF_API);
  }

  public findCategoryById(id: number){
    return this.http.get<Category>(this.PATH_OF_API+'/'+id);
  }

  public findAttributesOfCategory(idCategory: number){
    return this.http.get<Attribute[]>('http://localhost:9090/api/attributes/idCategory/'+idCategory);
  }

  public getCategoryTitle(category: Category): string{
    if(category.parentCategory!=null){
      return this.getCategoryTitle(category.parentCategory)+": "+category.name;
    }
    else{
      return category.name;
    }
  }
}
