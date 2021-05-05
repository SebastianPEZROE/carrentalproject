package com.mxtc.carrentalproject.models;

import java.time.LocalDateTime;

public class Rents {
    private int numberOfRent;//number of rent
    private int carId;
    private String clientName;
    private String clientLastname;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean reserved;

    public Rents() {
    }

    public Rents(int numberOfRent, int carId, String clientName, String clientLastname, LocalDateTime startTime, LocalDateTime endTime) {
        this.numberOfRent = numberOfRent;
        this.carId = carId;
        this.clientName = clientName;
        this.clientLastname = clientLastname;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getNumberOfRent() {
        return numberOfRent;
    }

    public void setNumberOfRent(int numberOfRent) {
        this.numberOfRent = numberOfRent;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientLastname() {
        return clientLastname;
    }

    public void setClientLastname(String clientLastname) {
        this.clientLastname = clientLastname;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "rents{" +
                "numberOfRent=" + numberOfRent +
                ", carId=" + carId +
                ", clientName='" + clientName + '\'' +
                ", clientLastname='" + clientLastname + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", reserved=" + reserved +
                '}';
    }
}
