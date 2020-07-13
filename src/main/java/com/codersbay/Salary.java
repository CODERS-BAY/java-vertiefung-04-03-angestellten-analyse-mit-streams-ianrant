package com.codersbay;

public class Salary {

    private Double nettoMonthly;
    private Double bruttoMonthly;

    public Salary(Double nettoMonthly, Double bruttoMonthly) {
        this.nettoMonthly = nettoMonthly;
        this.bruttoMonthly = bruttoMonthly;
    }

    public Double getNettoMonthly() {
        return nettoMonthly;
    }

    public void setNettoMonthly(Double nettoMonthly) {
        this.nettoMonthly = nettoMonthly;
    }

    public Double getBruttoMonthly() {
        return bruttoMonthly;
    }

    public void setBruttoMonthly(Double bruttoMonthly) {
        this.bruttoMonthly = bruttoMonthly;
    }

}
