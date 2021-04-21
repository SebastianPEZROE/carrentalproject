package com.mxtc.carrentalproject.models;

public class Car {
    private String model;
    private int numberOfCars;
    private boolean available;
    private double pricePerHour;

    public Car() {
    }

    public Car(String model, int numberOfCars, boolean available, double pricePerHour) {
        this.model = model;
        this.numberOfCars = numberOfCars;
        this.available = available;
        this.pricePerHour = pricePerHour;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", numberOfCars=" + numberOfCars +
                ", status=" + available +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}
