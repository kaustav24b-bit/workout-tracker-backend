package com.workout.tracker.repository;

import com.workout.tracker.model.WorkoutDay;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

// This interface handles all database operations for the WorkoutDay table.
// By extending JpaRepository, Spring automatically provides common operations
// like save(), findAll(), findById(), deleteById() — no SQL needed.
// <WorkoutDay, Long> means: operate on the WorkoutDay table, where the ID type is Long.
public interface WorkoutDayRepository extends JpaRepository<WorkoutDay, Long> {

    // Custom query method — Spring reads the method name and generates the SQL automatically.
    // This translates to: SELECT * FROM workout_day WHERE date = ?
    List<WorkoutDay> findByDate(LocalDate date);
}