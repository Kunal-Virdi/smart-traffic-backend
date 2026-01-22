package com.traffic.backend.model;

public class Signal {
    private final String signalId;
    private int greenTime;
    private int redTime;
    private boolean isGreen;

    public Signal(String signalId, int greenTime, int redTime) {
        this.signalId = signalId;
        this.greenTime = greenTime;
        this.redTime = redTime;
        this.isGreen = true;
    }

    public String getSignalId() {
        return signalId;
    }

    public boolean isGreen() {
        return isGreen;
    }

    public void switchSignal() {
        isGreen = !isGreen;
    }

    public void setGreenTime(int greenTime) {
        this.greenTime = greenTime;
    }

    public void setRedTime(int redTime){
        this.redTime = redTime;
    }

    public int getGreenTime(){
        return greenTime;
    }

    public int getRedTime(){
        return redTime;
    }

}
