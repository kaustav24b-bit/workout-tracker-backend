package com.workout.tracker.service;

import com.workout.tracker.model.ExerciseName;
import com.workout.tracker.repository.ExerciseNameRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExerciseNameService {

    private final ExerciseNameRepository exerciseNameRepository;

    public ExerciseNameService(ExerciseNameRepository exerciseNameRepository) {
        this.exerciseNameRepository = exerciseNameRepository;
    }

    public List<ExerciseName> getAllExerciseNames() {
        return exerciseNameRepository.findAll();
    }

    public ExerciseName createExerciseName(ExerciseName exerciseName) {
        // Don't save if name already exists
        if (exerciseNameRepository.existsByNameIgnoreCase(exerciseName.getName())) {
            throw new RuntimeException("Exercise name already exists");
        }
        return exerciseNameRepository.save(exerciseName);
    }

    public ExerciseName updateExerciseName(Long id, ExerciseName updated) {
        ExerciseName existing = exerciseNameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercise name not found"));
        existing.setName(updated.getName());
        return exerciseNameRepository.save(existing);
    }

    public void deleteExerciseName(Long id) {
        exerciseNameRepository.deleteById(id);
    }
}