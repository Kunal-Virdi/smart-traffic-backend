package com.traffic.backend.service;

import com.traffic.backend.graph.Edge;
import com.traffic.backend.graph.TrafficGraph;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

@Service
public class RouteOptimizer {
    public Map<String, Integer> dijkstra(
            TrafficGraph graph,
            String source) {
        Map<String, Integer> distanceMap = new HashMap<>();
        for (String node : graph.getAdjacencyList().keySet()) {
            distanceMap.put(node, Integer.MAX_VALUE);
        }
        distanceMap.put(source, 0);

        PriorityQueue<NodeDistance> pq =
                new PriorityQueue<>(Comparator.comparingInt(NodeDistance::getDistance));
        pq.add(new NodeDistance(source, 0));

        while (!pq.isEmpty()) {
            NodeDistance current = pq.poll();

            String currentNode = current.getNode();
            int currentDistance = current.getDistance();

            if (currentDistance > distanceMap.get(currentNode)) {
                continue;
            }

            for (Edge edge : graph.getAdjacencyList().get(currentNode)) {
                int newDistance = currentDistance + edge.getWeight();
                if (newDistance < distanceMap.get(edge.getDestination())) {
                    distanceMap.put(edge.getDestination(), newDistance);

                    pq.add(new NodeDistance(edge.getDestination(), newDistance));

                }
            }
        }
        return distanceMap;
    }
}