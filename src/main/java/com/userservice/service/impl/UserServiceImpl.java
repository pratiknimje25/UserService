package com.userservice.service.impl;

import com.userservice.clients.HotelService;
import com.userservice.clients.RatingService;
import com.userservice.entity.Hotel;
import com.userservice.entity.Rating;
import com.userservice.entity.User;
import com.userservice.exceptions.UserNotFoundException;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserRepository repository;

  @Autowired private HotelService hotelService;

  @Autowired private RatingService ratingService;

  @Override
  public User addUser(User user) {
    String userId = UUID.randomUUID().toString();
    user.setId(userId);
    return repository.save(user);
  }

  @Override
  public List<User> getAllUsers() {
    return repository.findAll();
  }

  @Override
  public User getUserById(String id) {
    // Get the user by user id
    Optional<User> user = repository.findById(id);
    if (user.isPresent()) {
      List<Rating> ratings = ratingService.getRatings(user.get().getId());
      user.get().setRatings(ratings);
      // Get the hotel details for each rating
      ratings.stream()
          .map(
              rating -> {
                // Get the hotel id from the rating
                Hotel hotel = hotelService.getHotel(rating.getHotelId());
                rating.setHotel(hotel);
                return rating;
              })
          .toList();

      return user.get();
    } else {
      throw new UserNotFoundException("User not found");
    }
  }

  @Override
  public boolean deleteUser(String id) {
    User user = getUserById(id);
    if (user != null) {
      repository.delete(user);
      return true;
    } else {
      return false;
    }
  }
}
