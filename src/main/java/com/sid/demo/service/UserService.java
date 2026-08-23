package com.sid.demo.service;

import com.sid.demo.model.User;

import java.util.List;
import java.util.Optional;

public class UserService {

    private final List<User> users = List.of(
            new User(1L, "Alice Johnson", "alice@example.com", "Admin"),
            new User(2L, "Bob Smith", "bob@example.com", "User"),
            new User(3L, "Charlie Brown", "charlie@example.com", "Manager"),
            new User(4L, "Diana Prince", "diana@example.com", "User"),
            new User(5L, "Ethan Hunt", "ethan@example.com", "Admin"),
            new User(6L, "Fiona Gallagher", "fiona@example.com", "User")
    );

    public List<User> getUsers() {
        System.out.println("Fetching all users: " + users.size());
        return users;
    }

    public Optional<User> getUserById(Long id) {
        System.out.println("Fetching user by ID: " + id);
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }
}
