package com.mxtc.carrentalproject.models;

import java.time.LocalDateTime;

public class RequiredParameters {
    private LocalDateTime start;
    private LocalDateTime end;
    private String type;
    //private int filterPrice1;
    //private int filterPrice2;
    private boolean orderByType;
    private boolean orderInvByType;
    private boolean orderByPrice;
    private boolean isOrderInvByPrice;

    public RequiredParameters() {
    }

    public RequiredParameters(LocalDateTime start, LocalDateTime end, String type, boolean orderByType,
                              boolean orderInvByType, boolean orderByPrice, boolean isOrderInvByPrice) {
        this.start = start;
        this.end = end;
        this.type = type;
        this.orderByType = orderByType;
        this.orderInvByType = orderInvByType;
        this.orderByPrice = orderByPrice;
        this.isOrderInvByPrice = isOrderInvByPrice;
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

    public boolean isOrderByType() {
        return orderByType;
    }

    public void setOrderByType(boolean orderByType) {
        this.orderByType = orderByType;
    }

    public boolean isOrderInvByType() {
        return orderInvByType;
    }

    public void setOrderInvByType(boolean orderInvByType) {
        this.orderInvByType = orderInvByType;
    }

    public boolean isOrderByPrice() {
        return orderByPrice;
    }

    public void setOrderByPrice(boolean orderByPrice) {
        this.orderByPrice = orderByPrice;
    }

    public boolean isOrderInvByPrice() {
        return isOrderInvByPrice;
    }

    public void setOrderInvByPrice(boolean orderInvByPrice) {
        isOrderInvByPrice = orderInvByPrice;
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
