import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from 'src/app/services/auth.guard';
import { CreateMovieComponent } from './create-movie/create-movie.component';

import { HomeComponent } from './home/home.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { RegisterUsesrComponent } from './register-usesr/register-usesr.component';
import { UpdateMovieComponent } from './update-movie/update-movie.component';

const routes: Routes = [
  {path:'',component:HomeComponent,pathMatch:'full'},
  {path :'login',component:LoginUserComponent},
  {path:'register',component:RegisterUsesrComponent},

  {path: "movie", component: MovieListComponent},
  {path: "",redirectTo: 'movie',pathMatch: 'full'},
  {path:'create-movies' , component: CreateMovieComponent},
  {path: 'updatemovie/:id', component:UpdateMovieComponent},
  {path: 'moviedetails/:id', component:MovieDetailsComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
