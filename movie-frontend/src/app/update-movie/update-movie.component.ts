import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from '../movie';
import { MovieService } from '../movie.service';

@Component({
  selector: 'app-update-movie',
  templateUrl: './update-movie.component.html',
  styleUrls: ['./update-movie.component.css']
})
export class UpdateMovieComponent implements OnInit {
  movie:Movie = new Movie();

  constructor(private movieService:MovieService, private route:ActivatedRoute,
    private router:Router) { }

 id:number|undefined;
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.movieService.getMovieById(this.id).subscribe(data => {
      this.movie = data;
    },
    error => console.log(error)
    );
  }
 
  
     onSubmit(){
     this.movieService.updateMovie(this.id, this.movie).subscribe(data =>{
            this.goToMovieList();
     },
     error => console.log(error)
     );
     
     }

     goToMovieList(){
       this.router.navigate(['/movie']);
     }
}
