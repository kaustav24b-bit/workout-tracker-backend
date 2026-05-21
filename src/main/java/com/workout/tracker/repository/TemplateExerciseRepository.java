package com.workout.tracker.repository;

import com.workout.tracker.model.TemplateExercise;
import com.workout.tracker.model.WorkoutTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemplateExerciseRepository extends JpaRepository<TemplateExercise, Long> {
    List<TemplateExercise> findByWorkoutTemplateId(Long id);
}
