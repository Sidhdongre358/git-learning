package com.sid.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.sid.demo.model.User;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>(List.of(
            new User(1L, "Alice Johnson", "alice@example.com", "Admin"),
            new User(2L, "Bob Smith", "bob@example.com", "User"),
            new User(3L, "Charlie Brown", "charlie@example.com", "Manager"),
            new User(4L, "Diana Prince", "diana@example.com", "User"),
            new User(5L, "Ethan Hunt", "ethan@example.com", "Admin"),
            new User(6L, "Fiona Gallagher", "fiona@example.com", "User")
    ));

    private final AtomicLong userSequence = new AtomicLong(users.stream()
            .mapToLong(User::getId)
            .max()
            .orElse(0L));

    public List<User> getUsers() {
        return users;
    }

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public User createUser(User user) {
        if (user == null || user.getName() == null || user.getName().isBlank()) {
            throw new IllegalArgumentException("User name is required");
        }
        if (user.getEmail() == null || user.getEmail().isBlank()) {
            throw new IllegalArgumentException("User email is required");
        }

        User newUser = new User(
                userSequence.incrementAndGet(),
                user.getName(),
                user.getEmail(),
                user.getRole() != null ? user.getRole() : "USER"
        );

        users.add(newUser);
        return newUser;
    }

    public Optional<User> updateUser(Long id, User updatedUser) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(existingUser -> {
                    if (updatedUser.getName() != null && !updatedUser.getName().isBlank()) {
                        existingUser.setName(updatedUser.getName());
                    }
                    if (updatedUser.getEmail() != null && !updatedUser.getEmail().isBlank()) {
                        existingUser.setEmail(updatedUser.getEmail());
                    }
                    if (updatedUser.getRole() != null && !updatedUser.getRole().isBlank()) {
                        existingUser.setRole(updatedUser.getRole());
                    }
                    return existingUser;
                });
    }

    public boolean deleteUser(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}
