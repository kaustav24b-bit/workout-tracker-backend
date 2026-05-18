package com.workout.tracker.repository;

import com.workout.tracker.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// This interface handles all database operations for the Exercise table.
// Same as WorkoutDayRepository but for Exercise entities.
// <Exercise, Long> means: operate on the Exercise table, where the ID type is Long.
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    // Custom query method — fetches all exercises that belong to a specific workout day.
    // This translates to: SELECT * FROM exercise WHERE workout_day_id = ?
    List<Exercise> findByWorkoutDayId(Long workoutDayId);
}