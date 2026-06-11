package com.workout.tracker.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "workout_day")
public class WorkoutDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String dayOfWeek;

    @Column(nullable = false)
    private LocalDate date;

    // Link to the user who owns this workout day
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // One workout day has many exercises
    // Ignore this field when serializing to JSON
    // It's only used internally for JPQL queries
    @JsonIgnore
    @OneToMany(mappedBy = "workoutDay", fetch = FetchType.LAZY)
    private List<Exercise> exercises;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDayOfWeek() { return dayOfWeek; }
    public void setDayOfWeek(String dayOfWeek) { this.dayOfWeek = dayOfWeek; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public List<Exercise> getExercises() { return exercises; }
    public void setExercises(List<Exercise> exercises) { this.exercises = exercises; }
}