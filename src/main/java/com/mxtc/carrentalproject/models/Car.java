package com.mxtc.carrentalproject.models;

/**
 *
 */
public class Car {
    private int car_id;
    private String model;
    private double pricePerHour;

    public Car() {
    }

    public Car(int car_id, String model, double pricePerHour) {
        this.car_id = car_id;
        this.model = model;
        this.pricePerHour = pricePerHour;
    }


    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
                "car_id=" + car_id +
                ", model='" + model + '\'' +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}
