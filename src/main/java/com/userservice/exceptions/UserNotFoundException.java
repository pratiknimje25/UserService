package com.userservice.exceptions;

public class UserNotFoundException extends RuntimeException {

  public UserNotFoundException() {
    super("User not found on server.");
  }

  public UserNotFoundException(String message) {
    super(message);
  }
}
