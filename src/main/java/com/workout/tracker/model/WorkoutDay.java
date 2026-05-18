package com.workout.tracker.model;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    // getters and setters
    public Long getId(){return id;}
    public void setId(Long id) {this.id = id;}

    public String getDayOfWeek(){return dayOfWeek;}
    public void setDayOfWeek(String dayOfWeek) {this.dayOfWeek = dayOfWeek;}

    public LocalDate getDate(){return date;}
    public void setDate(LocalDate date) {this.date = date;}
}
