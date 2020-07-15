package com.codersbay;

import java.util.Objects;

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

    @Override
    public String toString() {
        return nettoMonthly + " (" + bruttoMonthly + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salary)) return false;
        Salary salary = (Salary) o;
        return Objects.equals(getNettoMonthly(), salary.getNettoMonthly()) &&
                Objects.equals(getBruttoMonthly(), salary.getBruttoMonthly());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNettoMonthly(), getBruttoMonthly());
    }
}
