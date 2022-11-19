import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {

  credentials={
    username:'',
    password:''
  }
  constructor(private loginService:LoginService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log("Form is submitted");
    if((this.credentials.username!='' && this.credentials.password!='')
     && (this.credentials.username!=null && this.credentials.password!=null)){
         

         console.log("We have to submit the form to server");
         //token Generate
         this.loginService.genereteToken(this.credentials).subscribe(
           (response:any)=>{
             console.log(response.token);
             this.loginService.loginUser(response.token);
             window.location.href="/movie";

           },
           error=>{
             console.log(error);

           }
         )
     }
     else{
       console.log("Fields are Empty");
     }
  }

}
