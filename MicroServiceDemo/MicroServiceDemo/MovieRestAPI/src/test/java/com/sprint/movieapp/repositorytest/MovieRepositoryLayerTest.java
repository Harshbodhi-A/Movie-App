//package com.sprint.movieapp.repositorytest;
//
//import com.sprint.movieapp.model.Movie;
//import com.sprint.movieapp.repository.MovieRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//public class MovieRepositoryLayerTest {
//
//    @Autowired
//    private MovieRepository movieRepository;
//
//    private Movie movie;
//
//    @BeforeEach
//    public void setup(){
//        movie=new Movie();
//        movie.setId(4);
//        movie.setMovieName("Bahubali");
//        movie.setDatePlayed("22-12-2022");
//        movie.setDirectorName("Ramouli");
//    }
//
//    @Test
//    public void addMovieTesting(){
//        movieRepository.save(movie);
//        Movie movie1=movieRepository.findById(movie.getId()).get();
//        assertNotNull(movie1);
//        assertEquals(movie.getId(),movie1.getId());
//    }
//
//    @AfterEach
//    public void afterMethod(){
//        movieRepository.deleteAll();
//    }
//}
