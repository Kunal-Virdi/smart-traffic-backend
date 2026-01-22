package com.traffic.backend.model;

public class Road {
    private final String roadId;
    private final double length;
    private int trafficDensity;
    private int maxCapacity;

    public Road(String roadId, double length, int maxCapacity) {
        this.roadId = roadId;
        this.length = length;
        this.maxCapacity = maxCapacity;
        this.trafficDensity = 0;
    }

    public String getRoadId() {
        return roadId;
    }

    public double getLength() {
        return length;
    }

    public int getTrafficDensity() {
        return trafficDensity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void updateTrafficDensity(int currentVehicles) {
        if (currentVehicles < 0) {
            throw new IllegalArgumentException("Traffic density cannot be negative");
        }
        this.trafficDensity = currentVehicles;
    }

}
