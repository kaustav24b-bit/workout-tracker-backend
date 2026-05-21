package com.workout.tracker.repository;

import com.workout.tracker.model.WorkoutDay;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface WorkoutDayRepository extends JpaRepository<WorkoutDay, Long> {

    List<WorkoutDay> findByDateAndUserId(LocalDate date, Long userId);

}