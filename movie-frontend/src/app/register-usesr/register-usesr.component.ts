import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/user';

import { RegisterService } from '../services/register.service';

@Component({
  selector: 'app-register-usesr',
  templateUrl: './register-usesr.component.html',
  styleUrls: ['./register-usesr.component.css']
})
export class RegisterUsesrComponent implements OnInit {

  user:User = new User();
  constructor(private registerService:RegisterService, private router:Router) { }

  ngOnInit(): void {
  }
saveUser(){
  this.registerService.getUserRegister(this.user).subscribe(data=>{
    console.log(data);
  },

  error => console.log(error));
}
gotologinpage(){

  this.router.navigate(['/login'])
}

onSubmit(){
  console.log(this.user);
  this.saveUser();
}

}
