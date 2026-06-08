package com.workout.tracker.dto;

import java.time.LocalDate;

// Represents the summary of the last session for a specific exercise
public class LastSessionSummary {
    private LocalDate date;
    private double minWeight;
    private double maxWeight;

    public LastSessionSummary(LocalDate date, double minWeight, double maxWeight) {
        this.date = date;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    public LocalDate getDate() { return date; }
    public double getMinWeight() { return minWeight; }
    public double getMaxWeight() { return maxWeight; }
}