package com.workout.tracker.service;

import com.workout.tracker.model.Exercise;
import com.workout.tracker.repository.ExerciseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// Marks this class as a Service — Spring will manage it as a bean.
// This is where business logic for Exercise lives.
@Service
public class ExerciseService {

    // Spring automatically injects the repository.
    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    // Returns all exercises belonging to a specific workout day.
    public List<Exercise> getExercisesByWorkoutDayId(Long workoutDayId) {
        return exerciseRepository.findByWorkoutDayId(workoutDayId);
    }

    // Saves a new exercise to the database.
    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    // Updates an existing exercise — save() handles both create and update.
    public Exercise updateExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    // Deletes an exercise by its ID.
    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }
}