import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url="http://localhost:9091/api/v1"

  constructor(private http:HttpClient) { }

//calling the server to generate token
genereteToken(credentials:any){
  return this.http.post(`${this.url}/login`,credentials);
}

//for login user
  loginUser(token: any){
    localStorage.setItem("token",token)
    return true;
  }

  //to ckeck that is user is logged in or not
  isLoggendIn(){
    let token = localStorage.getItem("token");
    if(token==undefined || token==='' || token==null){
      return false;
    }
    else{
      return true;
    }
  }

  logout(){
    localStorage.removeItem('token')
    return true;
  }

  //for getting the token
  getToken(){
    return localStorage.getItem("token");
  }
}
