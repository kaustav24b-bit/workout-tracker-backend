package com.workout.tracker.controller;

import com.workout.tracker.dto.TemplateRequest;
import com.workout.tracker.model.TemplateExercise;
import com.workout.tracker.model.WorkoutTemplate;
import com.workout.tracker.model.User;
import com.workout.tracker.service.WorkoutTemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST controller for WorkoutTemplate endpoints.
@RestController
@RequestMapping("/api/templates")
public class WorkoutTemplateController {

    // Spring automatically injects the service
    private final WorkoutTemplateService workoutTemplateService;

    public WorkoutTemplateController(WorkoutTemplateService workoutTemplateService) {
        this.workoutTemplateService = workoutTemplateService;
    }

    // GET /api/templates?userId=1
    // Returns all templates belonging to a specific user
    @GetMapping
    public List<WorkoutTemplate> getAllTemplates(@RequestParam Long userId) {
        return workoutTemplateService.getAllTemplates(userId);
    }

    // POST /api/templates
    // Creates a new template with a list of exercise names
    // Request body example:
    // {
    //   "name": "Push Day 1",
    //   "userId": 1,
    //   "exerciseNames": ["Bench Press", "Squat", "Shoulder Press"]
    // }
    @PostMapping
    public WorkoutTemplate createTemplate(@RequestBody TemplateRequest request) {
        // Build the WorkoutTemplate object from the request
        WorkoutTemplate template = new WorkoutTemplate();
        template.setName(request.getName());

        // Link the template to the user by id
        User user = new User();
        user.setId(request.getUserId());
        template.setUser(user);

        // Pass the template and exercise names to the service
        return workoutTemplateService.createTemplate(template, request.getExerciseNames());
    }

    // GET /api/templates/{id}/exercises — returns all exercises for a template
    @GetMapping("/{id}/exercises")
    public List<TemplateExercise> getTemplateExercises(@PathVariable Long id) {
        return workoutTemplateService.getTemplateExercises(id);
    }

    // DELETE /api/templates/{id}
    // Deletes a template by its id
    @DeleteMapping("/{id}")
    public void deleteTemplate(@PathVariable Long id) {
        workoutTemplateService.deleteTemplate(id);
    }
}