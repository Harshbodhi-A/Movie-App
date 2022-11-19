package com.sprint.movieapp.service;

import com.sprint.movieapp.exception.CustomException;
import com.sprint.movieapp.model.Movie;
import com.sprint.movieapp.model.User;
import com.sprint.movieapp.proxy.UserProxy;
import com.sprint.movieapp.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private UserProxy userProxy;
    @Autowired
    private MovieRepository movieRepository;

//    @Autowired
//    public MovieService(UserProxy userProxy,MovieRepository movieRepository){
//        this.userProxy=userProxy;
//        this.movieRepository=movieRepository;
//    }

//    public String addMovie(Movie movie) {
//        movieRepository.save(movie);
//        return movie.getDatePlayed();
//    }

    public User registerUser(User user){
        ResponseEntity responseEntity=userProxy.registerUser(user);
        System.out.println(responseEntity);
        return movieRepository.save(user);
    }

    public User saveUserMovieToList(Movie movie,String username){
        User user=movieRepository.findByUsername(username);
        if(user!=null){
            if(user.getMovieList()==null){
                user.setMovieList(Arrays.asList(movie));
            }else{
                List favList=user.getMovieList();
                favList.add(movie);
                user.setMovieList(favList);
            }
            return movieRepository.save(user);
        }else{
            return user;
        }
    }

//    public List<Movie> listAllMovies() {
//        return movieRepository.findAll();
//    }
//
//    public Movie getMovie(int id) throws CustomException {
//        if(movieRepository.findById(id).isEmpty()){
//            throw new CustomException();
//        }else{
//            return movieRepository.findById(id).get();
//        }
//    }

    public String deleteAllMovies(){
        movieRepository.deleteAll();
        return "Cleared Successfully";
    }

    public String deleteMovie(int id) throws CustomException {
        if(movieRepository.findById(id).isEmpty()){
            throw new CustomException();
        }else{
            movieRepository.findById(id).get();
            return "Movie Deleted";
        }
    }
}
