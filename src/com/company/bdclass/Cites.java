package com.company.bdclass;

public class Cites {
    private String name;
    private int id;
    private int company;
    private int country;
    private double fuel;

    public Cites(String name, int id, int company, int country, double fuel) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.country = country;
        this.fuel = fuel;

    }

    public Cites() {
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getCompany() {
        return this.company;
    }

    public int getCountry() {
        return this.country;
    }

    public double getFuel() {
        return this.fuel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public void setFuel(double fuel) {
        this.fuel += fuel;
    }

}
