package com.workout.tracker.controller;

import com.workout.tracker.model.Exercise;
import com.workout.tracker.model.WorkoutDay;
import com.workout.tracker.service.ExerciseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// REST controller for Exercise endpoints.
@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    // GET /api/exercises/by-workout-day/{id} — returns all exercises for a workout day
    @GetMapping("/by-workout-day/{workoutDayId}")
    public List<Exercise> getByWorkoutDay(@PathVariable Long workoutDayId) {
        return exerciseService.getExercisesByWorkoutDayId(workoutDayId);
    }

    // POST /api/exercises — creates a new exercise
    @PostMapping
    public Exercise createExercise(@RequestBody Exercise exercise) {
        return exerciseService.createExercise(exercise);
    }

    // PUT /api/exercises/{id} — updates an existing exercise
    @PutMapping("/{id}")
    public Exercise updateExercise(@PathVariable Long id, @RequestBody Exercise exercise) {
        exercise.setId(id);
        return exerciseService.updateExercise(exercise);
    }

    // DELETE /api/exercises/{id} — deletes an exercise by ID
    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
    }
}