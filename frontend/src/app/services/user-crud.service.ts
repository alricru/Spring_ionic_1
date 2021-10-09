import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

export class User {
  id: number;
  name: string;
  genre: string;
  year: string;
  platform: string;
  pegi: string;
}

@Injectable({
  providedIn: 'root'
})
export class UserCrudService {
  endpoint = 'http://localhost:8080/videogames';

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/x-www-form-urlencoded'})
  };
  constructor(private httpClient: HttpClient) { }

  createVideoGame(User: User): Observable<any>{
    let bodyencoded = new URLSearchParams();
    bodyencoded.append("name",User.name);
    bodyencoded.append("genre",User.genre);
    bodyencoded.append("year",User.year);
    bodyencoded.append("platform",User.platform);
    bodyencoded.append("pegi",User.pegi);
    const body = bodyencoded.toString();
    return this.httpClient.post<User>(this.endpoint, body, this.httpOptions)
      .pipe(
        catchError(this.handleError<User>('Error occured'))
      );
  }

  getVideoGame(id): Observable<User[]>{
    return this.httpClient.get<User[]>(this.endpoint + '/' + id)
    .pipe(
      tap(_ => console.log('videogames fetched: ${id}')),
      catchError(this.handleError<User[]>('Get user id=${id}'))
    );
  }

  getVideoGames(): Observable<User[]>{
    return this.httpClient.get<User[]>(this.endpoint)
    .pipe(
      tap(User => console.log('videogames retrieved!')),
      catchError(this.handleError<User[]>('Get videogames', []))
    );
  }

  updateVideoGames(id, User: User): Observable<any> {
    return this.httpClient.put(this.endpoint + '/' + id, JSON.stringify(User), this.httpOptions)
    .pipe(
      tap(_ => console.log('videogame updated: ${id}')),
      catchError(this.handleError<User[]>('Update videogame'))
    );
  }

  deleteVideoGames(id): Observable<User[]>{
    return this.httpClient.delete<User[]>(this.endpoint + '/' + id, this.httpOptions)
    .pipe(
      tap(_ => console.log('videogame deleted: ${id}')),
      catchError(this.handleError<User[]>('Delete videoGame'))
    );
  }
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
}}
