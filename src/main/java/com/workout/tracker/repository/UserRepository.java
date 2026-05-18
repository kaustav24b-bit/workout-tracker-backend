package com.workout.tracker.repository;

import com.workout.tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserById(Long userId);
}
