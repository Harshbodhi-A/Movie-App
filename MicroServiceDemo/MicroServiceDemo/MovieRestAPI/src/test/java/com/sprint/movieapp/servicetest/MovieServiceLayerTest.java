//package com.sprint.movieapp.servicetest;
//
//import com.sprint.movieapp.model.Movie;
//import com.sprint.movieapp.repository.MovieRepository;
//import com.sprint.movieapp.service.MovieService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//public class MovieServiceLayerTest {
//
//    @Mock
//    private MovieRepository movieRepository;
//
//    @InjectMocks
//    private MovieService movieService;
//
//    private Movie movie;
//
//    @BeforeEach
//    public void setup(){
//        movie=new Movie();
//        movie.setId(7);
//        movie.setMovieName("Movie 7");
//        movie.setDatePlayed("22-12-2017");
//        movie.setDirectorName("Director 7");
//    }
//
//    @Test
//    public void addMovieServiceTest(){
//        when(movieRepository.save(any())).thenReturn(movie);
//        assertEquals(movie.getDatePlayed(),movieService.addMovie(movie));
//    }
//}
