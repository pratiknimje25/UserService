package com.userservice.exceptions;

import com.userservice.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ApiResponse> handleUserNotFoundException(UserNotFoundException ex) {

    ApiResponse response =
        ApiResponse.builder()
            .message(ex.getMessage())
            .success(true)
            .status(HttpStatus.NOT_FOUND)
            .build();
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }
}
