package com.hco.entities;

import java.io.Serializable;
import java.util.Objects;

public class Bus implements Serializable {
    private int busNo;
    private String registrationNo;
    private String modelName;
    private String make;
    private int capacity;
    private double price;

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bus bus)) return false;
        return getBusNo() == bus.getBusNo() && getCapacity() == bus.getCapacity() && Double.compare(getPrice(), bus.getPrice()) == 0 && Objects.equals(getRegistrationNo(), bus.getRegistrationNo()) && Objects.equals(getModelName(), bus.getModelName()) && Objects.equals(getMake(), bus.getMake());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBusNo(), getRegistrationNo(), getModelName(), getMake(), getCapacity(), getPrice());
    }

    @Override
    public String toString() {
        return "Bus{" +
                "busNo=" + busNo +
                ", registrationNo='" + registrationNo + '\'' +
                ", modelName='" + modelName + '\'' +
                ", make='" + make + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }
}
