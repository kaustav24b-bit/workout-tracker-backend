package com.workout.tracker.dto;

import java.util.List;

// DTO (Data Transfer Object) — represents the shape of the POST request body.
// We use a DTO instead of the entity directly because we need extra fields
// (userId and exerciseNames) that don't belong on the WorkoutTemplate entity.
public class TemplateRequest {
    private String name;
    private Long userId;
    private List<String> exerciseNames;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public List<String> getExerciseNames() { return exerciseNames; }
    public void setExerciseNames(List<String> exerciseNames) { this.exerciseNames = exerciseNames; }
}