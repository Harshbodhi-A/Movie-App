import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/user';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  baseURL="http://localhost:9090/api/v1/register";

  constructor(private httpClient: HttpClient) { }

  getUserRegister(user:User):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`,user);
  }
}
