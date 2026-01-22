package com.traffic.backend.service;
import com.traffic.backend.model.Road;
import com.traffic.backend.model.Vehicle;
import com.traffic.backend.model.VehicleType;
import org.springframework.stereotype.Service;

@Service
public class TrafficWeightCalculator {
    public int calculatorWeight(Road road, Vehicle vehicle){
        int baseWeight = (int) road.getLength();
        double congestionRatio = (double) road.getTrafficDensity() / road.getMaxCapacity();
        int trafficPenalty = (int) (baseWeight * congestionRatio * 2);

        if (vehicle.getType() == VehicleType.AMBULANCE ||
                vehicle.getType() == VehicleType.FIRE_TRUCK) {

            trafficPenalty = trafficPenalty / 5;

        }

        return baseWeight + trafficPenalty;
    }
}
