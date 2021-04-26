package com.mxtc.carrentalproject.models;

import java.time.LocalDateTime;

public class RequiredParameters {
    private LocalDateTime start;
    private LocalDateTime end;
    private String type;
    private int price1;
    private int price2;
    private boolean orderByType;
    private boolean orderInvByType;
    private boolean orderByPrice;
    private boolean isOrderInvByPrice;

    public RequiredParameters() {
    }

    public RequiredParameters(LocalDateTime start, LocalDateTime end, String type) {
        this.start = start;
        this.end = end;
        this.type = type;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RequiredParameters{" +
                "start=" + start +
                ", end=" + end +
                ", type='" + type + '\'' +
                '}';
    }
}
