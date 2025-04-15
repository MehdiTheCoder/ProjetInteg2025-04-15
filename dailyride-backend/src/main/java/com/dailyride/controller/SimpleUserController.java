package com.dailyride.controller;

import com.dailyride.model.SimpleUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/users")
public class SimpleUserController {

    // Simple in-memory storage
    private Map<String, SimpleUser> users = new ConcurrentHashMap<>();

    // Create a new user
    @PostMapping
    public SimpleUser createUser(@RequestBody SimpleUser user) {
        users.put(user.getEmail(), user);
        return user;
    }

    // Get all users
    @GetMapping
    public List<SimpleUser> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    // Get user by email
    @GetMapping("/{email}")
    public SimpleUser getUser(@PathVariable String email) {
        return users.get(email);
    }

    // Update user
    @PutMapping("/{email}")
    public SimpleUser updateUser(@PathVariable String email, @RequestBody SimpleUser user) {
        users.put(email, user);
        return user;
    }

    // Delete user
    @DeleteMapping("/{email}")
    public void deleteUser(@PathVariable String email) {
        users.remove(email);
    }
} 