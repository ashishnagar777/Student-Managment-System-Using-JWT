package com.Student.main.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Student.main.entities.User;
import com.Student.main.repository.UserRepository;
import com.Student.main.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}