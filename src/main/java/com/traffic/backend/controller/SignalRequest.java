package com.traffic.backend.controller;

import com.traffic.backend.model.Road;
import com.traffic.backend.model.Signal;

public class SignalRequest {

    private Signal signal;
    private Road road;

    public Signal getSignal(){
        return signal;
    }

    public void setSignal(Signal signal){
        this.signal = signal;
    }

    public Road getRoad(){
        return road;
    }

    public void setRoad(){
        this.road = road;
    }
}
