import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Comment } from 'src/app/_model/Comment';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  PATH_OF_API = 'http://localhost:9090/api/comments';

  constructor(private http: HttpClient) { }

  public insert(comment: Comment){
    return this.http.post<Comment>(this.PATH_OF_API, comment);
  }

  public findAll(){
    return this.http.get<Comment[]>(this.PATH_OF_API);
  }

  public findCommentsByIdOffer(id: number){
    return this.http.get<Comment[]>(this.PATH_OF_API+'/idOffer/'+id);
  }
}
