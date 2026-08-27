package com.traffic.backend;

import com.traffic.backend.simulation.TrafficSimulator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SmartTrafficBackendApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(
                        SmartTrafficBackendApplication.class,
                        args
                );

        TrafficSimulator simulator =
                context.getBean(TrafficSimulator.class);

        simulator.startSimulation(10);
    }
}