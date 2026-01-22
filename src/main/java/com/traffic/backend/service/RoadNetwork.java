package com.traffic.backend.service;

import com.traffic.backend.graph.TrafficGraph;
import com.traffic.backend.model.Road;
import com.traffic.backend.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RoadNetwork {
    private final Map<String, Road> roadMap = new HashMap<>();
    private final TrafficWeightCalculator calculator =
            new TrafficWeightCalculator();

    public void addRoad(
            String source,
            String destination,
            Road road,
            TrafficGraph graph,
            Vehicle vehicle
    ){
        roadMap.put(source + "-" + destination, road);
        int weight = calculator.calculatorWeight(road, vehicle);

        graph.addEdge(source, destination, weight);
    }
}
