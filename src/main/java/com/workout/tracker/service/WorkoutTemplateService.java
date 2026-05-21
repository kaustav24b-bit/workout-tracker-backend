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

}
