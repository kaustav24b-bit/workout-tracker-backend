package com.workout.tracker.controller;

import com.workout.tracker.model.WorkoutDay;
import com.workout.tracker.service.WorkoutDayService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/workout-days")
public class WorkoutDayController {

    private final WorkoutDayService workoutDayService;

    public WorkoutDayController(WorkoutDayService workoutDayService) {
        this.workoutDayService = workoutDayService;
    }

    // GET /api/workout-days — returns all workout days
    @GetMapping
    public List<WorkoutDay> getAllWorkoutDays() {
        return workoutDayService.getAllWorkoutDays();
    }

    // POST /api/workout-days — gets or creates a workout day for a specific date and user
    @PostMapping
    public WorkoutDay createWorkoutDay(@RequestBody WorkoutDay workoutDay) {
        return workoutDayService.getOrCreateWorkoutDay(workoutDay);
    }

    // DELETE /api/workout-days/{id} — deletes a workout day by ID
    @DeleteMapping("/{id}")
    public void deleteWorkoutDay(@PathVariable Long id) {
        workoutDayService.deleteWorkoutDay(id);
    }
}