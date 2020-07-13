package com.codersbay;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employees = employeeService.getEmployees();
    }

}
