import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user.models';
import { IUser } from '../interfaces/user.interface';
import { map, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private BASE_URL = 'http://localhost:8080/api/user';
  private http = inject(HttpClient);

  getAll(): Observable<User[]> {
    return this.http.get<IUser[]>(this.BASE_URL).pipe(
      map(userArray => {
        return userArray.map<User>(
          userArray => User.fromJson(userArray)
        )
      })
    );
  }

  get(userNamr: string): Observable<User[]> {
    return this.http.get<IUser[]>(this.BASE_URL+userNamr+'/').pipe(
      map(userArray => {
        return userArray.map<User>(
          userArray => User.fromJson(userArray)
        )
      })
    );
  }

  add(user: User): Observable<User> {
    return this.http.post<IUser>(this.BASE_URL, user.toJson()).pipe(
      map(userAdd => User.fromJson(userAdd))
    )
  }
  
  update(user: User): Observable<User>  {
     return this.http.put<IUser>(this.BASE_URL+ user.id , user.toJson()).pipe(
      map(userAdd => User.fromJson(userAdd))
    ) 
  }


}
