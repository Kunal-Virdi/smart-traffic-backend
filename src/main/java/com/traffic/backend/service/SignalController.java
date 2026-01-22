package com.traffic.backend.service;

import com.traffic.backend.model.Road;
import com.traffic.backend.model.Signal;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class SignalController {
    public void optimizeSignal(Signal signal, Road road){
        int minGreenTime = 20;
        int maxGreenTime = 120;
        double congestionRatio = (double) road.getTrafficDensity() / road.getMaxCapacity();

        int newGreenTime = (int) (minGreenTime + (maxGreenTime - minGreenTime) * congestionRatio);

        signal.setGreenTime(newGreenTime);
        signal.setRedTime(maxGreenTime - newGreenTime);

    }
}
