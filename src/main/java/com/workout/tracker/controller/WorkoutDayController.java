package com.workout.tracker.controller;

import com.workout.tracker.model.WorkoutDay;
import com.workout.tracker.service.WorkoutDayService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

// Marks this as a REST controller — all methods return JSON automatically.
// @CrossOrigin allows your React frontend to call this API (CORS policy).
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

    // GET /api/workout-days/by-date?date=2026-05-17 — returns workout days for a specific date
    @GetMapping("/by-date")
    public List<WorkoutDay> getByDate(@RequestParam LocalDate date) {
        return workoutDayService.getWorkoutDaysByDate(date);
    }

    // POST /api/workout-days — creates a new workout day
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