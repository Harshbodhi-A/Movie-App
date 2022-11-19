import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Movie } from './movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private baseURL = "http://localhost:8585/api/v2/movies";

  constructor(private httpClient: HttpClient) { }

  getMovieList(): Observable<Movie[]>{
    return this.httpClient.get<Movie[]>(`${this.baseURL}`);
  }

  createMovie(movie:Movie):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,movie);
  }

  getMovieById(id:number|undefined):Observable<Movie>{
    return this.httpClient.get<Movie>(`${this.baseURL}/${id}`)
  }

  updateMovie(id:number|undefined, movie:Movie): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,movie);
  }

  deleteMovie(id:number|undefined): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
