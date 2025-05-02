package com.userservice.controller;

import com.userservice.entity.User;
import com.userservice.exceptions.UserNotFoundException;
import com.userservice.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired private UserService service;

  @PostMapping("/save")
  public ResponseEntity<User> saveUser(@RequestBody User user) {
    return ResponseEntity.ok(service.addUser(user));
  }

  @GetMapping("/all")
  public ResponseEntity<List<User>> getAllUsers() {
    return ResponseEntity.ok(service.getAllUsers());
  }

  @GetMapping("/one/{id}")
  public ResponseEntity<User> getOneUser(@PathVariable String id) {
    return ResponseEntity.ok(service.getUserById(id));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable String id) {
    if (service.deleteUser(id)) {
      return ResponseEntity.ok("User deleted successfully");
    } else {
      return ResponseEntity.badRequest().body(new UserNotFoundException("User not found"));
    }
  }
}
