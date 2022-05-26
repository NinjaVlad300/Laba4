package com.company.bdclass;

public class Regions {
    private String name;
    private int id;
    private double fuel_consumpion;

    public Regions(String name, int id, double fuel_consumpion) {
        this.id = id;
        this.name = name;
        this.fuel_consumpion = fuel_consumpion;
    }

    public Regions() {

    }

    public String getName() {
        return this.name;
    }

    public Double getFuelConsuption() {
        return this.fuel_consumpion;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFuelConsuption(Double fuel_consumpion) {
        this.fuel_consumpion += fuel_consumpion;
    }
}
