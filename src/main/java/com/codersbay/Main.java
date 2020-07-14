package com.codersbay;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> employees = employeeService.getEmployees();


        // AUFGABE 1 - ver 1
        // CEO finden
        System.out.println("\nfind CEO - version 1:");
        List<Employee> searchForCEO = employees.stream()
                .filter(person -> person.getTeamLead() == null && person.getName().equals("Max Mustermann"))
                .collect(Collectors.toList()); // sammelt alle Objekte und überträgt sie in die Liste
        searchForCEO.forEach(System.out::println);

        // AUFGABE 1 - ver 2
        System.out.println("\nfind CEO - version 2:");
        System.out.println();
        employees.stream()
                .filter(person -> person.getTeamLead() == null && person.getName().equals("Max Mustermann"))
                .forEach(o -> System.out.println(o.getName() + ", " + o.getGender() + " " + o.getSalary()));


        // AUFGABE 2
        System.out.println("\nemployees and salary:");
        System.out.println();
        employees.stream()
                .forEach(o -> System.out.println(o.getName() + ", " + o.getSalary()));


        // AUFGABE 3 (maybe try reverse?)
        // alle Mitarbeiter und Gehalt, aufsteigend nach Gehalt
        System.out.println("\nemployees and salary, ascending:");
        employees.stream()
                .sorted((o2, o1) -> Double.compare(o1.getSalary().getBruttoMonthly(), o2.getSalary().getBruttoMonthly()))
                .forEach(o -> System.out.println(o.getName() + ", " + o.getSalary()));

        // AUFGABE 4
        // alle Departments ohne Duplikate
        System.out.println("\nunique department:");
        employees.stream()
                .distinct()
                .forEach(o -> System.out.println(o.getDepartment()));


        System.out.println("-------------------");
    }

}
