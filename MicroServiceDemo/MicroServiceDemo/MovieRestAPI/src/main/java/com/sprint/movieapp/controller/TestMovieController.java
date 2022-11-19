package com.sprint.movieapp.controller;

import com.sprint.movieapp.model.Movie;
import com.sprint.movieapp.model.User;
import com.sprint.movieapp.repository.MovieRepository;
import com.sprint.movieapp.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2")
public class TestMovieController {

    ResponseEntity responseEntity;

    @Autowired
    MovieRepository movieRepository;
    @Autowired
    MovieService movieService;

    @GetMapping("/home")
    public String home(){
        return "Welcome TestMovieController";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user){
        try{
            responseEntity=new ResponseEntity<>(movieService.registerUser(user), HttpStatus.CREATED);
        }catch (Exception e){
            responseEntity=new ResponseEntity<>("Not registered",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("/user/{username}/movie")
    public ResponseEntity<?> saveFavMovie(@RequestBody Movie movie,@PathVariable String username){
        return responseEntity=new ResponseEntity<>(movieService.saveUserMovieToList(movie,username),HttpStatus.OK);
    }

    @DeleteMapping("/movie/{id}")
    public String deleteMoviesById(String username, int id) {
        User user = movieRepository.findByUsername(username);
        if(user!=null){
            if(user.getMovieList()==null){
                System.out.println("No Movies Available");
                return "No Movies Available";
            }else{
                for(int i=0;i<user.getMovieList().size();i++){
                    if(user.getMovieList().get(i).getId()==id){
                        user.getMovieList().remove(i);
                        return "Movie Deleted";
                    }
                }
            }
        }
        return "No User Is There";
    }


    @PutMapping("/movie/{id}")
    public String updateMoviesById(String username, int id, Movie movie) {
        User user = movieRepository.findByUsername(username);
        if(user!=null){
            if(user.getMovieList()==null){
                System.out.println("No Movies Available");
                return "No Movies Available";
            }else{
                for(int i=0;i<user.getMovieList().size();i++){
                    if(user.getMovieList().get(i).getId()==id){
                        user.getMovieList().set(i,movie);
                        return "Movie Updated ";
                    }
                }
            }
        }
        return "No User Available" ;
    }
}
