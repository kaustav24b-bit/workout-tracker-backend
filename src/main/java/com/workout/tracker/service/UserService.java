package com.workout.tracker.service;

import com.workout.tracker.model.User;
import com.workout.tracker.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// Marks this class as a Service — Spring will manage it as a bean.
// This is where business logic for WorkoutDay lives.
@Service
public class UserService {

    // Spring automatically injects the repository — no need to create it manually.
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Returns all users from the database.
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Saves a new user to the database.
    public User createUser(User user) {
        // Set a temporary token so nullable = false constraint is satisfied
        user.setUserToken("temp");
        // First save to generate the id
        User saved = userRepository.save(user);
        // Then compute and set the token using id + username
        saved.setUserToken(saved.getId() + "_" + saved.getUsername());
        // Save again with the token
        return userRepository.save(saved);
    }

    // Deletes a user by its ID.
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Updates a user by its ID.
    public User updateUser(Long id, User updatedUser) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setUserToken(updatedUser.getUserToken());

        return userRepository.save(existingUser);
    }
}