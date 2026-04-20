package com.Student.main.services;


import com.Student.main.entities.User;

public interface UserService {

    User saveUser(User user);

    User findByUsername(String username);
}
