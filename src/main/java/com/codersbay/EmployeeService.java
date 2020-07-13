package com.codersbay;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private List<Employee> employees;

    public EmployeeService() {
        Department marketing = new Department(1, "Marketing");
        Department softwareDevelopment = new Department(2, "Software Development");
        Department operations = new Department(3, "Operations");
        Department leads = new Department(4, "Leads");
        Employee ceo = new Employee("Max Mustermann", Gender.MALE, new Salary(3250.0, 4750.0), leads, null);
        Employee marketingLead = new Employee("Veronika Bauer", Gender.FEMALE, new Salary(2000.0, 2750.0), marketing, ceo);
        Employee developmentLead = new Employee("Manuel Mayer", Gender.MALE, new Salary(2850.0, 3550.0), softwareDevelopment, ceo);
        Employee operationsLead = new Employee("Franz Schubert", Gender.MALE, new Salary(2200.0, 2950.0), operations, ceo);
        this.employees = new ArrayList<>();
        this.employees.add(marketingLead);
        this.employees.add(developmentLead);
        this.employees.add(operationsLead);
        this.employees.add(ceo);
        this.employees.add(new Employee("Sarah Huber", Gender.FEMALE, new Salary(1250.0, 1750.0), marketing, marketingLead));
        this.employees.add(new Employee("Bianca Schweiger", Gender.FEMALE, new Salary(1350.0, 1800.0), marketing, marketingLead));
        this.employees.add(new Employee("Otto Steiner", Gender.MALE, new Salary(1350.0, 1800.0), operations, operationsLead));
        this.employees.add(new Employee("Mario Bart", Gender.MALE, new Salary(1150.0, 1500.0), operations, operationsLead));
        this.employees.add(new Employee("Fritz Fraunhuber", Gender.OTHER, new Salary(1050.0, 1300.0), operations, operationsLead));
        this.employees.add(new Employee("Paul Ulrich", Gender.MALE, new Salary(1050.0, 1300.0), operations, operationsLead));
        this.employees.add(new Employee("Maria Musterfrau", Gender.FEMALE, new Salary(1800.0, 2000.0), softwareDevelopment, developmentLead));
        this.employees.add(new Employee("Elon Musk", Gender.MALE, new Salary(2250.0, 2400.0), softwareDevelopment, developmentLead));
        this.employees.add(new Employee("Bill Gates", Gender.MALE, new Salary(2350.0, 2600.0), softwareDevelopment, developmentLead));
        this.employees.add(new Employee("Steve Jobs", Gender.MALE, new Salary(1950.0, 2100.00), softwareDevelopment, developmentLead));
    }

    public List<Employee> getEmployees() {
        return employees;
    }

}
