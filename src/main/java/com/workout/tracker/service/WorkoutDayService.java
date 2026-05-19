package com.workout.tracker.service;

import com.workout.tracker.model.WorkoutDay;
import com.workout.tracker.repository.WorkoutDayRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkoutDayService {

    private final WorkoutDayRepository workoutDayRepository;

    public WorkoutDayService(WorkoutDayRepository workoutDayRepository) {
        this.workoutDayRepository = workoutDayRepository;
    }

    // Returns all workout days from the database.
    public List<WorkoutDay> getAllWorkoutDays() {
        return workoutDayRepository.findAll();
    }

    // Gets existing workout day for this date+user, or creates a new one.
    public WorkoutDay getOrCreateWorkoutDay(WorkoutDay workoutDay) {
        List<WorkoutDay> existing = workoutDayRepository.findByDateAndUserId(
                workoutDay.getDate(),
                workoutDay.getUser().getId()
        );
        if (!existing.isEmpty()) {
            return existing.get(0);
        }
        return workoutDayRepository.save(workoutDay);
    }

    // Deletes a workout day by its ID.
    public void deleteWorkoutDay(Long id) {
        workoutDayRepository.deleteById(id);
    }
}