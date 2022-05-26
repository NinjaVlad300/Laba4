package com.company.bdclass;

public class Units {
    private String clas;
    private String name;
    private String status;
    private Double burnup;
    private Double termal_capacity;
    private Double load_factor;
    private Double fuel_consumption;
    private int site;

    public Units(Double burnup, String name, String clas, String status,  Double termal_capacity, Double load_factor, Double fuel_consumption, int site) {
        this.burnup = burnup;
        this.name = name;
        this.clas = clas;
        this.load_factor = load_factor;
        this.termal_capacity = termal_capacity;
        this.status = status;
        this.fuel_consumption = fuel_consumption;
        this.site = site;
    }

    public Units() {
    }

    public String getClas() {
        return this.clas;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public Double getBurnup() {
        return this.burnup;
    }

    public Double getTermal_capasity() {
        return this.termal_capacity;
    }

    public Double getLoad_factor() {
        return this.load_factor;
    }

    public int getSite() {
        return this.site;
    }

    public void setClasss(String clas) {
        this.clas = clas;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setBurnup(Double burnup) {
        this.burnup = burnup;
    }

    public void setTermal_capasity(Double termal_capacity) {
        this.termal_capacity = termal_capacity;
    }

    public void setLoad_factor(Double load_factor) {
        this.load_factor = load_factor;
    }

    public Double getFuel_consumption() {
        this.fuel_consumption = this.termal_capacity * this.load_factor*365/(this.burnup*100000);  //тепловая мощность*коэфф. использ установленной мощности
                                                                                                   // /коэфф. выгорания
        double value = Math.round(this.fuel_consumption * 100) / 100;//Округляет число до ближайшего целого

        return value;
    }

    public void setSite(int site) {
        this.site = site;
    }
}
