package com.traffic.backend.model;

public class Vehicle {
    private String vehicleId;
    private VehicleType type;
    private double speed;
    private int priority;

    public Vehicle(String vehicleId, VehicleType type, double speed, int priority) {
        this.vehicleId = vehicleId;
        this.type = type;
        this.speed = speed;
        this.priority = priority;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public VehicleType getType() {
        return type;
    }

    public double getSpeed() {
        return speed;
    }

    public int getPriority() {
        return priority;
    }
}


