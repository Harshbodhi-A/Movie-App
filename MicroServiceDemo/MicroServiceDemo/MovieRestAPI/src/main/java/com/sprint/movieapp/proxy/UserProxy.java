package com.sprint.movieapp.proxy;

import com.sprint.movieapp.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-authentication-service")
public interface UserProxy {
    @PostMapping("/api/v1/register")
    public ResponseEntity<?> registerUser(@RequestBody User user);
}
