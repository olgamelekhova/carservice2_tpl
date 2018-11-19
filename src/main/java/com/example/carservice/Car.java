package com.example.carservice;

import java.io.Serializable;

public class Car implements Serializable {

    private String plateNumber;
    private String brand;
    private int price;
    private boolean isRented;

    public Car() {
    }

    public Car(String plateNumber, String brand, int price) {
        super();
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.isRented = false;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isRented() {
        return isRented;
    }

    public void toRent(boolean toRent) {
        this.isRented = toRent;
    }

    boolean rentCar() {
        if (isRented) {
            return false;
        }

        isRented = true;
        return isRented;
    }

    boolean getBackCar() {
        if (!isRented) {
            return false;
        }

        isRented = false;
        return !isRented;
    }

    @Override
    public String toString() {
        return "Car [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + "]";
    }
}
