package com.workout.tracker.service;

import com.workout.tracker.model.WorkoutDay;
import com.workout.tracker.repository.WorkoutDayRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

// Marks this class as a Service — Spring will manage it as a bean.
// This is where business logic for WorkoutDay lives.
@Service
public class WorkoutDayService {

    // Spring automatically injects the repository — no need to create it manually.
    private final WorkoutDayRepository workoutDayRepository;

    public WorkoutDayService(WorkoutDayRepository workoutDayRepository) {
        this.workoutDayRepository = workoutDayRepository;
    }

    // Returns all workout days from the database.
    public List<WorkoutDay> getAllWorkoutDays() {
        return workoutDayRepository.findAll();
    }

    // Finds workout days by a specific date.
    public List<WorkoutDay> getWorkoutDaysByDate(LocalDate date) {
        return workoutDayRepository.findByDate(date);
    }

    // Saves a new workout day to the database.
    public WorkoutDay createWorkoutDay(WorkoutDay workoutDay) {
        return workoutDayRepository.save(workoutDay);
    }

    // Deletes a workout day by its ID.
    public void deleteWorkoutDay(Long id) {
        workoutDayRepository.deleteById(id);
    }
}