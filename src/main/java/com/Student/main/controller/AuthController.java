package com.Student.main.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.Student.main.entities.User;
import com.Student.main.security.JwtUtil;
import com.Student.main.services.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    // ✅ REGISTER
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return ResponseEntity.ok(service.saveUser(user));
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {

        User existing = service.findByUsername(user.getUsername());

        if (existing == null) {
            return ResponseEntity.status(404).body("User not found");
        }

        if (!passwordEncoder.matches(user.getPassword(), existing.getPassword())) {
            return ResponseEntity.status(401).body("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return ResponseEntity.ok(token);
    }
}
