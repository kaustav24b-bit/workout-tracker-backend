package com.workout.tracker.service;

import com.workout.tracker.dto.StatPoint;
import com.workout.tracker.model.Exercise;
import com.workout.tracker.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.workout.tracker.dto.LastSessionSummary;
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

    public List<StatPoint> getStatsForExercise(String name, Long userId) {
        // Only fetch last 2 months of data
        LocalDate startDate = LocalDate.now().minusMonths(2);
        List<Exercise> exercises = exerciseRepository.findByNameAndUserIdSince(name, userId, startDate);

        // Group by date and sum up reps * weight for each date
        Map<LocalDate, Double> totals = new LinkedHashMap<>();
        for (Exercise e : exercises) {
            LocalDate date = e.getWorkoutDay().getDate();
            double contribution = e.getReps() * e.getWeight();
            totals.merge(date, contribution, Double::sum);
        }

        // Convert map to list of StatPoints
        return totals.entrySet().stream()
                .map(entry -> new StatPoint(entry.getKey(), entry.getValue()))
                .collect(java.util.stream.Collectors.toList());
    }

    public LastSessionSummary getLastSessionSummary(String name, Long userId) {
        List<Exercise> exercises = exerciseRepository.findLastSessionExercises(name, userId);

        if (exercises.isEmpty()) return null;

        // Find min and max weight from last session
        double minWeight = exercises.stream()
                .mapToDouble(Exercise::getWeight)
                .min()
                .orElse(0);
        double maxWeight = exercises.stream()
                .mapToDouble(Exercise::getWeight)
                .max()
                .orElse(0);

        LocalDate date = exercises.get(0).getWorkoutDay().getDate();

        return new LastSessionSummary(date, minWeight, maxWeight);
    }
}