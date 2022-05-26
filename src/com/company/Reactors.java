package com.company;

public class Reactors {
    private String name;
    private double burnup;
    private double kpd;
    private double enrichment;
    private double termal_capacity;
    private double electrical_capacity;
    private double life_time;
    private double first_load;
    private String source;

    public Reactors(String name, double burnup, double kpd, double enrichment, double termal_capacity,
                   double electrical_capacity, double life_time, double first_load, String source) {
        this.name = name;
        this.burnup = burnup;
        this.kpd = kpd;
        this.enrichment = enrichment;
        this.termal_capacity = termal_capacity;
        this.electrical_capacity = electrical_capacity;
        this.life_time = life_time;
        this.first_load = first_load;
        this.source = source;
    }

    public Reactors() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBurnup() {
        return burnup;
    }

    public void setBurnup(double burnup) {
        this.burnup = burnup;
    }

    public double getKpd() {
        return kpd;
    }

    public void setKpd(double kpd) {
        this.kpd = kpd;
    }

    public double getEnrichment() {
        return enrichment;
    }

    public void setEnrichment(double enrichment) {
        this.enrichment = enrichment;
    }

    public double getTermal_capacity() {
        return termal_capacity;
    }

    public void setTermal_capacity(double termal_capacity) {
        this.termal_capacity = termal_capacity;
    }

    public double getElectrical_capacity() {
        return electrical_capacity;
    }

    public void setElectrical_capacity(double electrical_capacity) {
        this.electrical_capacity = electrical_capacity;
    }

    public double getLife_time() {
        return life_time;
    }

    public void setLife_time(double life_time) {
        this.life_time = life_time;
    }

    public double getFirst_load() {
        return first_load;
    }

    public void setFirst_load(double first_load) {
        this.first_load = first_load;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}