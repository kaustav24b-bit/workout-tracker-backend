package com.workout.tracker.dto;

import java.time.LocalDate;

// Represents one data point on the stats chart —
// the total weight moved for an exercise on a specific date.
public class StatPoint {
    private LocalDate date;
    private double totalWeight;

    public StatPoint(LocalDate date, double totalWeight) {
        this.date = date;
        this.totalWeight = totalWeight;
    }

    public LocalDate getDate() { return date; }
    public double getTotalWeight() { return totalWeight; }
}