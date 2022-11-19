package com.sprint.movieapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This id doesn't exist, kindly enter another one")
public class CustomException extends Exception{
}
