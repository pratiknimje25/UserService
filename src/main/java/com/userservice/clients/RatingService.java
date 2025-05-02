package com.userservice.clients;

import com.userservice.entity.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "RATING-MICROSERVICE")
public interface RatingService {

  @GetMapping("/rating/user/{userId}")
  List<Rating> getRatings(@PathVariable("userId") String userId);
}
