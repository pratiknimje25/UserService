package com.userservice.service;

import com.userservice.entity.User;
import java.util.List;

public interface UserService {


    User addUser(User user);

    List<User> getAllUsers();

    User getUserById(String id);

    boolean deleteUser(String id);
}
