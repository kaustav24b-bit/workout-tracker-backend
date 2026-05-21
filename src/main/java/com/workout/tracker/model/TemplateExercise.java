package com.workout.tracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "template_exercise")
public class TemplateExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String exerciseName;

    @ManyToOne
    @JoinColumn(name = "workout_template_id", nullable = false)
    private WorkoutTemplate workoutTemplate;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return exerciseName; }
    public void setName(String exerciseName) { this.exerciseName = exerciseName; }

    public WorkoutTemplate getWorkoutTemplate() { return workoutTemplate; }
    public void setWorkoutTemplate(WorkoutTemplate workoutTemplate) { this.workoutTemplate = workoutTemplate; }
}
