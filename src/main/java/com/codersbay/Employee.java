package com.codersbay;

public class Employee {

    private String name;
    private Gender gender;
    private Salary salary;
    private Department department;
    private Employee teamLead;

    public Employee(String name,
                    Gender gender,
                    Salary salary,
                    Department department,
                    Employee teamLead) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.department = department;
        this.teamLead = teamLead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(Employee teamLead) {
        this.teamLead = teamLead;
    }

    @Override
    public String toString() {
        return name + ", " +
                gender + ", monthly salary " +
                salary + ", " +
                department + ", " +
                teamLead;
    }
}
