package com.company.bdclass;

public class Countries {
    private String name;
    private int id;
    private int region;
    private double fuel_consumption;

    public Countries(String name, int id, int region, double fuel_consumption) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.fuel_consumption = fuel_consumption;
    }

    public Countries() {

    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getRegion() {
        return this.region;
    }

    public Double getFuelConsuption() {
        return this.fuel_consumption;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public void setFuelConsuption(Double fuel_consumption) {
        this.fuel_consumption += fuel_consumption;
    }

}
