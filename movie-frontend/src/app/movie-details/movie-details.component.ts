import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.css']
})
export class MovieDetailsComponent implements OnInit {

  id:number|undefined;
  movies:Movie | undefined;

  constructor(private route: ActivatedRoute, private movieService : MovieService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.movies = new Movie();
    this.movieService.getMovieById(this.id).subscribe(data =>{
      this.movies = data;
    });
  }

}


