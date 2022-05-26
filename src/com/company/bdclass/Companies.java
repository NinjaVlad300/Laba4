package com.company.bdclass;

public class Companies {
    private String name;
    private int id;
    private int country;
    private double fuel_consumpion;

    public Companies(String name, int id, int country, double fuel_consumpion) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.fuel_consumpion = fuel_consumpion;

    }

    public Companies() {

    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getCountry() {
        return this.country;
    }

    public Double getFuelConsuption() {
        return this.fuel_consumpion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public void setFuelConsuption(Double fuel_consumpion) {
        this.fuel_consumpion += fuel_consumpion;
    }

}

