package com.workout.tracker.service;

import com.workout.tracker.model.TemplateExercise;
import com.workout.tracker.model.WorkoutTemplate;
import com.workout.tracker.repository.TemplateExerciseRepository;
import com.workout.tracker.repository.WorkoutTemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutTemplateService {
    private final WorkoutTemplateRepository workoutTemplateRepository;
    private final TemplateExerciseRepository templateExerciseRepository;
    
    public WorkoutTemplateService(WorkoutTemplateRepository workoutTemplateRepository, TemplateExerciseRepository templateExerciseRepository){
        this.workoutTemplateRepository = workoutTemplateRepository;
        this.templateExerciseRepository = templateExerciseRepository;
    }

    public List<WorkoutTemplate> getAllTemplates(Long userId){
        return workoutTemplateRepository.findByUserId(userId);
    }

    public void deleteTemplate(Long id) {
        workoutTemplateRepository.deleteById(id);
    }

    // Returns all exercises belonging to a specific template
    public List<TemplateExercise> getTemplateExercises(Long templateId) {
        return templateExerciseRepository.findByWorkoutTemplateId(templateId);
    }

    public WorkoutTemplate createTemplate(WorkoutTemplate template, List<String> exerciseNames) {
        // Step 1: Save the template first to generate its id
        WorkoutTemplate saved = workoutTemplateRepository.save(template);

        // Step 2: Loop through exerciseNames
        for (String name : exerciseNames) {
            // Create a new TemplateExercise
            TemplateExercise te = new TemplateExercise();
            // Set the exercise name
            te.setName(name);
            // Link it to the saved template
            te.setWorkoutTemplate(saved);
            // Save it
            templateExerciseRepository.save(te);
        }

        // Step 3: Return the saved template
        return saved;
    }

    // Update template name
    public WorkoutTemplate updateTemplateName(Long id, String name) {
        WorkoutTemplate existing = workoutTemplateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found"));
        existing.setName(name);
        return workoutTemplateRepository.save(existing);
    }

    // Add an exercise to an existing template
    public TemplateExercise addExerciseToTemplate(Long templateId, String exerciseName) {
        WorkoutTemplate template = workoutTemplateRepository.findById(templateId)
                .orElseThrow(() -> new RuntimeException("Template not found"));
        TemplateExercise te = new TemplateExercise();
        te.setName(exerciseName);
        te.setWorkoutTemplate(template);
        return templateExerciseRepository.save(te);
    }

    // Remove an exercise from a template
    public void removeExerciseFromTemplate(Long exerciseId) {
        templateExerciseRepository.deleteById(exerciseId);
    }

}
