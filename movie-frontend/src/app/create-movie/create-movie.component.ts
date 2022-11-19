import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-create-movie',
  templateUrl: './create-movie.component.html',
  styleUrls: ['./create-movie.component.css']
})
export class CreateMovieComponent implements OnInit {

  movie:Movie = new Movie();
  constructor(private movieService:MovieService, private router:Router) { }

  ngOnInit(): void {
  }
  saveMovie(){
    this.movieService.createMovie(this.movie).subscribe(data =>{
      console.log(data);
      this.goToMovieList();
    },
    error => console.log(error));
  }

  goToMovieList(){
 this.router.navigate(['/movie']);
  }
  onSubmit(){
  console.log(this.movie);
  this.saveMovie();
  }

}
