import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ImageRequest } from 'src/app/_model/ImageRequest';
import { Image } from 'src/app/_model/Image';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  PATH_OF_API = 'http://localhost:9090/api/images';

  constructor(private http: HttpClient) { }

  public insert(image: ImageRequest){
    return this.http.post<Image>(this.PATH_OF_API, image);
  }

  public findAll(){
    return this.http.get<Image[]>(this.PATH_OF_API);
  }
}
