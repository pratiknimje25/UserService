package com.userservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_microservice")
public class User {

  @Id private String id;

  @Column(name = "user_name")
  private String name;

  @Column(name = "user_email")
  private String email;

  @Column(name = "user_password")
  private String password;

  @Column(name = "user_role")
  private String role;

  @Column(name = "user_phone_number")
  private String phoneNumber;

  @Column(name = "user_address")
  private String address;

  @Column(name = "user_ratings")
  @Transient
  private List<Rating> ratings = new ArrayList<>();
}
