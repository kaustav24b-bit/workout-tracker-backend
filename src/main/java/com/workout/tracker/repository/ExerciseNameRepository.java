package com.workout.tracker.repository;

import com.workout.tracker.model.ExerciseName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseNameRepository extends JpaRepository<ExerciseName, Long> {
    boolean existsByNameIgnoreCase(String name);
}