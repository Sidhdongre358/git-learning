package com.sid.demo.controller;

import com.sid.demo.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final List<User> users = List.of(
            new User(1L, "Alice Johnson", "alice@example.com", "Admin"),
            new User(2L, "Bob Smith", "bob@example.com", "User"),
            new User(3L, "Charlie Brown", "charlie@example.com", "Manager"),
            new User(4L, "Diana Prince", "diana@example.com", "User"),
            new User(5L, "Ethan Hunt", "ethan@example.com", "Admin"),
            new User(6L, "Fiona Gallagher", "fiona@example.com", "User")
    );

    @GetMapping("/users")
    public List<User> getUsers() {
        return users;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
