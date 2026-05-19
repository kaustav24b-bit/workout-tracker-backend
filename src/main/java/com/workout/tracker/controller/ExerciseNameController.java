package com.workout.tracker.controller;

import com.workout.tracker.model.ExerciseName;
import com.workout.tracker.service.ExerciseNameService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exercise-names")
public class ExerciseNameController {

    private final ExerciseNameService exerciseNameService;

    public ExerciseNameController(ExerciseNameService exerciseNameService) {
        this.exerciseNameService = exerciseNameService;
    }

    // GET /api/exercise-names — returns all exercise names
    @GetMapping
    public List<ExerciseName> getAllExerciseNames() {
        return exerciseNameService.getAllExerciseNames();
    }

    // POST /api/exercise-names — creates a new exercise name
    @PostMapping
    public ExerciseName createExerciseName(@RequestBody ExerciseName exerciseName) {
        return exerciseNameService.createExerciseName(exerciseName);
    }

    // PUT /api/exercise-names/{id} — updates an exercise name
    @PutMapping("/{id}")
    public ExerciseName updateExerciseName(@PathVariable Long id, @RequestBody ExerciseName exerciseName) {
        return exerciseNameService.updateExerciseName(id, exerciseName);
    }

    // DELETE /api/exercise-names/{id} — deletes an exercise name
    @DeleteMapping("/{id}")
    public void deleteExerciseName(@PathVariable Long id) {
        exerciseNameService.deleteExerciseName(id);
    }
}