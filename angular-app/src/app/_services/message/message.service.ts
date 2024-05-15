import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Message } from 'src/app/_model/Message';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  PATH_OF_API = 'http://localhost:9090/api/messages';

  constructor(private http: HttpClient) { }

  public insert(message: Message){
    return this.http.post<Message>(this.PATH_OF_API, message);
  }
}
