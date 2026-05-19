package com.workout.tracker.model;

import jakarta.persistence.*;

// Stores the list of exercise names available in the workout dropdown.
// This is separate from Exercise which stores actual workout data.
@Entity
@Table(name = "exercise_name")
public class ExerciseName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}