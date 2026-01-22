package com.traffic.backend.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrafficGraph {
    private Map<String, List<Edge>> adjacencyList;

    public TrafficGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String source, String destination, int weight) {

        addNode(source);
        addNode(destination);

        adjacencyList.get(source).add(new Edge(destination, weight));
    }

    public void displayGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print(node + " -> ");
            for (Edge edge : adjacencyList.get(node)) {
                System.out.print("(" + edge.getDestination() +
                        ", " + edge.getWeight() + ") ");
            }
            System.out.println();
        }
    }

    public Map<String, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }


}
