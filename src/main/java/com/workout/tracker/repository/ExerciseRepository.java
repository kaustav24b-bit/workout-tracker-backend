package com.workout.tracker.repository;

import com.workout.tracker.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

// This interface handles all database operations for the Exercise table.
// Same as WorkoutDayRepository but for Exercise entities.
// <Exercise, Long> means: operate on the Exercise table, where the ID type is Long.
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    // Custom query method — fetches all exercises that belong to a specific workout day.
    // This translates to: SELECT * FROM exercise WHERE workout_day_id = ?
    List<Exercise> findByWorkoutDayId(Long workoutDayId);

    // Fetch all exercises by name for a specific user in the last 2 months
    @Query("SELECT e FROM Exercise e " +
            "JOIN e.workoutDay wd " +
            "WHERE e.name = :name " +
            "AND wd.user.id = :userId " +
            "AND wd.date >= :startDate " +
            "ORDER BY wd.date ASC")
    List<Exercise> findByNameAndUserIdSince(
            @Param("name") String name,
            @Param("userId") Long userId,
            @Param("startDate") LocalDate startDate
    );
}