package com.workout.tracker.service;

import com.workout.tracker.model.User;
import com.workout.tracker.model.WorkoutDay;
import com.workout.tracker.repository.UserRepository;
import com.workout.tracker.repository.WorkoutDayRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
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
        return userRepository.save(user);
    }

    // Deletes a user by its ID.
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    // Updates a user by its ID.
    public User updateUser(Long userId, User updatedUser) {

        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setUserToken(updatedUser.getUserToken());

        return userRepository.save(existingUser);
    }
}