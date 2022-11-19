import { enableProdMode, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { CreateMovieComponent } from './create-movie/create-movie.component';
import { FormsModule } from '@angular/forms';
import { UpdateMovieComponent } from './update-movie/update-movie.component';
import { MovieDetailsComponent } from './movie-details/movie-details.component';
import { RegisterUsesrComponent } from './register-usesr/register-usesr.component';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from '@angular/material/button';

import { HomeComponent } from './home/home.component';

import {MatToolbarModule} from '@angular/material/toolbar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { LoginUserComponent } from './login-user/login-user.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { NewComponent } from './new/new.component';

@NgModule({
  declarations: [
    AppComponent,
    MovieListComponent,
    CreateMovieComponent,
    UpdateMovieComponent,
    MovieDetailsComponent,
    RegisterUsesrComponent,
    HomeComponent,
    LoginUserComponent,
    NavBarComponent,
    NewComponent
    
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    MatInputModule,
    MatFormFieldModule,
    



  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
