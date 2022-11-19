import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {


movies: Movie[] | undefined ;

  constructor(private movieService: MovieService, private router: Router) { }

  ngOnInit(): void {
  this.getMovies();
  }

  private getMovies(){
    this.movieService.getMovieList().subscribe(data =>{
      this.movies = data;
    });
  }

  movieDetails(id:number|undefined){
    this.router.navigate(['moviedetails', id]);
  }

  updateMovie(id:number|undefined){
    this.router.navigate(['updatemovie', id]);
  }

  deleteMovie(id:number|undefined){
    this.movieService.deleteMovie(id).subscribe(data =>{
      console.log(data);
      this.getMovies();
    });
  }
}
