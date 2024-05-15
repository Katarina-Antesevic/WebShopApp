import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/_model/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  PATH_OF_API = 'http://localhost:9090/api/users';

  constructor(private http: HttpClient) { }

  public insert(user: User) {
    return this.http.post<User>(this.PATH_OF_API, user);
  }

  public update(user: User) {
    return this.http.put<User>(this.PATH_OF_API + '/' + user.id, user);
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.PATH_OF_API);
  }

  public findByUsername(username: string): Observable<User> {
    return this.http.get<User>(this.PATH_OF_API + '/username/' + username);
  }
}
