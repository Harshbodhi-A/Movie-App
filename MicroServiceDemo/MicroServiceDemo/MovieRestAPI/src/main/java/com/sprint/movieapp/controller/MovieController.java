//package com.sprint.movieapp.controller;
//
//import com.sprint.movieapp.exception.CustomException;
//import com.sprint.movieapp.model.Movie;
//import com.sprint.movieapp.service.MovieService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v2")
//public class MovieController {
//    @Autowired
//    MovieService movieService;
//
//    @GetMapping("/")
//    public String getMapping(){
//        return "Oh Hey! Welcome";
//    }
//
//    @PostMapping("/addMovie")
//    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
//        return new ResponseEntity<String>(movieService.addMovie(movie), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/movieList")
//    public ResponseEntity<List<Movie>> getAllMovies(){
//        return new ResponseEntity<List<Movie>>(movieService.listAllMovies(),HttpStatus.OK);
//    }
//
//    @GetMapping("/movieId/{id}")
//    public ResponseEntity<Movie> getMovie(@PathVariable("id") int id) throws CustomException {
//        return new ResponseEntity<Movie>(movieService.getMovie(id),HttpStatus.OK);
//    }
//
//    @DeleteMapping("/movieId/{id}")
//    public ResponseEntity<String> deleteMovie(@PathVariable("id") int id) throws CustomException {
//        return new ResponseEntity<String>(movieService.deleteMovie(id),HttpStatus.OK);
//    }
//
//    @DeleteMapping("/clear")
//    public ResponseEntity<String> deleteAllMovie(){
//        return new ResponseEntity<String>(movieService.deleteAllMovies(),HttpStatus.OK);
//    }
//}
