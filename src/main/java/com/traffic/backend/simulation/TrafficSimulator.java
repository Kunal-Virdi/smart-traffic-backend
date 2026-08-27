package com.traffic.backend.simulation;

import com.traffic.backend.model.Road;
import com.traffic.backend.model.Signal;
import com.traffic.backend.service.SignalController;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrafficSimulator {
    private final List<Road> roads;
    private final List<Signal> signals;
    private final SignalController signalController;

    public TrafficSimulator(
            List<Road> roads,
            List<Signal> signals
    ){
        this.roads = roads;
        this.signals = signals;
        this.signalController = new SignalController();
    }

    public void startSimulation(int ticks){
        for (int t = 1; t <= ticks; t++) {
            System.out.println("\n TICK " + t);
            updateTraffic();
            optimizeSignals();
            displayState();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    private void updateTraffic(){
        for(Road road: roads){
            int change = (int) (Math.random() * 20 - 10);
            int newDensity = road.getTrafficDensity() + change;
            newDensity = Math.max(0,
                    Math.min(newDensity, road.getMaxCapacity()));

            road.updateTrafficDensity(newDensity);
        }
    }

    private void optimizeSignals(){
        for (int i = 0; i < signals.size(); i++) {
            signalController.optimizeSignal(
                    signals.get(i),
                    roads.get(i)
            );
        }
    }

    private void displayState(){
        for (int i = 0; i < roads.size(); i++) {
            Road road = roads.get(i);
            Signal signal = signals.get(i);
            System.out.println("Road " + road.getRoadId() +
                    " | Traffic: " + road.getTrafficDensity() +
                    " | Green: " + signal.getGreenTime() +
                    " | Red: " + signal.getRedTime() );
        }
    }
}
