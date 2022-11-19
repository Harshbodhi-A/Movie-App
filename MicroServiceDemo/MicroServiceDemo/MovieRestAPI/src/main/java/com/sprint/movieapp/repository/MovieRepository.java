package com.sprint.movieapp.repository;

import com.sprint.movieapp.model.Movie;
import com.sprint.movieapp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<User, Integer> {
    public User findByUsername(String username);
}
