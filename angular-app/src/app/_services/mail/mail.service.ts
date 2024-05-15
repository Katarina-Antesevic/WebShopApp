import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Mail } from 'src/app/_model/Mail';

@Injectable({
  providedIn: 'root'
})
export class MailService {

  PATH_OF_API = 'http://localhost:9090/api/mail';

  constructor(private http: HttpClient) { }

  public sendMail(mail: Mail){
    return this.http.post<Mail>(this.PATH_OF_API, mail);
  }
}
