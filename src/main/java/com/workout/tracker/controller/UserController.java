package com.workout.tracker.controller;

import com.workout.tracker.model.Exercise;
import com.workout.tracker.model.User;
import com.workout.tracker.model.WorkoutDay;
import com.workout.tracker.service.ExerciseService;
import com.workout.tracker.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// REST controller for Exercise endpoints.
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET /api/workout-days — returns all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // POST /api/exercises — creates a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // PUT /api/exercises/{id} — updates an existing user
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        user.setUserId(userId);
        return userService.updateUser(userId, user);
    }

    // DELETE /api/exercises/{id} — deletes an user by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}