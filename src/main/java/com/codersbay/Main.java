package com.codersbay;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    static EmployeeService employeeService = new EmployeeService();
    static List<Employee> employees = employeeService.getEmployees();


    public static void findCEOV1() {
        // AUFGABE 1 - ver 1
        // find the CEO
        System.out.println("\nfind CEO - version 1:");
        Optional<Employee> searchForCEO =
                employees.stream()
                        .filter(person -> person.getTeamLead() == null)
                        .findFirst();
        // if Optionals are applied, there is no need for collect()
        //.collect(Collectors.toList()); // sammelt alle Objekte und überträgt sie in die Liste
        if (searchForCEO.isPresent()) {
            Employee CEO = searchForCEO.get();
            System.out.println(CEO);
        } else {
            System.out.println("No CEO found!");
        }
        // isEmpty() ist gegenstück zu isPresent()
    }

    public static void findCEOV2() {
        // AUFGABE 1 - ver 2
        // find the CEO
        System.out.println("\nfind CEO - version 2:");
        System.out.println();
        employees.stream()
                .filter(person -> person.getTeamLead() == null)
                .forEach(o -> System.out.println(o.getName() + ", " + o.getGender() + " " + o.getSalary()));
    }

    public static void findCEOV3() {
        // AUFGABE 1 - ver 1
        // find the CEO
        System.out.println("\nfind CEO - version 3:");
        List<Employee> searchForCEO =
                employees.stream()
                        .filter(person -> person.getTeamLead() == null)
                        .collect(Collectors.toList()); // sammelt alle Objekte und überträgt sie in die Liste
        searchForCEO.forEach(System.out::println);
    }

    public static void employeeSalary() {
        // AUFGABE 2
        // show employees and their salary
        System.out.println("\nemployees and salary:");
        System.out.println();
        employees.stream()
                .forEach(o -> System.out.println(o.getName() + ", " + o.getSalary()));
    }

    public static void employeeSalaryAscV1() {
        // AUFGABE 3
        // alle Mitarbeiter und Gehalt, aufsteigend nach Gehalt
        System.out.println("\nemployees and salary, ascending according to salary:");
        employees.stream()
                .sorted((o2, o1) -> Double.compare(o1.getSalary().getBruttoMonthly(), o2.getSalary().getBruttoMonthly()))
                .forEach(o -> System.out.println(o.getName() + ", " + o.getSalary()));
    }

    public static void employeeSalaryAscV2() {
        // AUFGABE 3
        // alle Mitarbeiter und Gehalt, aufsteigend nach Name
        System.out.println("\nemployees and salary, ascending according to name:");
        employees.stream()
                .sorted((o2, o1) -> CharSequence.compare(o1.getName(), o2.getName()))
                .forEach(o -> System.out.println(o.getName() + ", " + o.getSalary()));

    }

    public static void showDepartmentsV1() {
        // AUFGABE 4 - v1
        // all departments distinct
        System.out.println("\nunique department - version 1:");
        Set<Department> departmentSet = new HashSet<>();
        employees.stream()
                .sorted(Comparator.comparingInt(o -> o.getDepartment().getId()))
                .forEach(e -> departmentSet.add(e.getDepartment()));
        departmentSet.forEach(System.out::println);
    }

    public static void showDepartmentsV2() {
        // AUFGABE 4 - v2
        // all departments distinct
        System.out.println("\nunique department - version 2:");
        employees.stream()
                .map(emp -> emp.getDepartment())
                .distinct()
                .sorted(Comparator.comparingInt(Department::getId))
                .forEach(System.out::println);
    }

    public static void showDepartmentsV3() {
        // AUFGABE 4 - v3
        // all departments distinct
        System.out.println("\nunique department - version 3:");
        Set<Department> departmentSet = new HashSet<>();
        employees.stream()
                .collect(Collectors.toSet());
        departmentSet.forEach(System.out::println);
    }

    public static void averageSalaryPerGender() {
        // AUFGABE 5
        // average salary per gender group
        System.out.println("\naverage wages per gender:");
        // .values is applicable to an enum an returns all the values that it holds
        // so it automatically delivers new enum values when they are added in the class
        for (Gender gender : Gender.values()) {
            Double resultNet = employees.stream()
                    .filter(person -> person.getGender() == gender)
                    .mapToDouble(person -> person.getSalary().getNettoMonthly()).average().getAsDouble();

            Double resultGross = employees.stream()
                    .filter(person -> person.getGender() == gender)
                    .mapToDouble(person -> person.getSalary().getBruttoMonthly()).average().getAsDouble();

            System.out.println(String.format(gender.toString().toLowerCase() + " employees earn an average of %7.2f (%7.2f) per month", resultNet, resultGross));
        }
    }

    public static void departmentGenders() {
        // AUFGABE 6
        // geschlechterverteilung in departments
        System.out.println("\npersons of each gender per department");

        List<String> departmentNames = employees.stream()
                .map(emp -> emp.getDepartment().getName())
                .distinct()
                .collect(Collectors.toList());

        for (String department : departmentNames) {
            for (Gender gender : Gender.values()) {
                long count = employees.stream()
                        .filter(emp -> emp.getGender() == gender && emp.getDepartment().getName().equals(department)).count();
                System.out.println("in dep " + department + " there are " + count + " " + gender.toString().toLowerCase() + " employees");
            }
        }
    }

    public static void rangeOfSalary() {

        System.out.println("\nrange of salaries within company");
        Optional<Employee> searchForCEO = employees.stream()
                .filter(person -> person.getTeamLead() == null)
                .findFirst();
        Employee CEO = searchForCEO.get();

        Predicate<Employee> isTeamLead = emp -> emp.getTeamLead() == CEO || emp.getTeamLead() == null;

        Double minNetSalStaff = employees.stream()
                .filter(isTeamLead.negate())
                .mapToDouble(emp -> emp.getSalary().getNettoMonthly())
                .min().getAsDouble();
        System.out.println(minNetSalStaff + " is the lowest net salary of the staff");

        Double maxNetSalStaff = employees.stream()
                .filter(isTeamLead.negate())
                .mapToDouble(emp -> emp.getSalary().getNettoMonthly())
                .max().getAsDouble();
        System.out.println(maxNetSalStaff + " is the highest net salary of the staff");


        Double minGrossSalStaff = employees.stream()
                .filter(isTeamLead.negate())
                .mapToDouble(emp -> emp.getSalary().getBruttoMonthly())
                .min().getAsDouble();
        System.out.println(minGrossSalStaff + " is the lowest gross salary of the staff");


        Double maxGrossSalStaff = employees.stream()
                .filter(isTeamLead.negate())
                .mapToDouble(emp -> emp.getSalary().getBruttoMonthly())
                .max().getAsDouble();
        System.out.println(maxGrossSalStaff + " is the highest gross salary of the staff");
        ////////////////

        Double minNetSalLead = employees.stream()
                .filter(isTeamLead)
                .mapToDouble(emp -> emp.getSalary().getNettoMonthly())
                .min().getAsDouble();
        System.out.println(minNetSalLead + " is the lowest net salary of the leads");

        Double maxNetSalLead = employees.stream()
                .filter(isTeamLead)
                .mapToDouble(emp -> emp.getSalary().getNettoMonthly())
                .max().getAsDouble();
        System.out.println(maxNetSalLead + " is the highest net salary of the leads");

        Double minGrossSalLead = employees.stream()
                .filter(isTeamLead)
                .mapToDouble(emp -> emp.getSalary().getBruttoMonthly())
                .min().getAsDouble();
        System.out.println(minGrossSalLead + " is the lowest gross salary of the leads");

        Double maxGrossSalLead = employees.stream()
                .filter(isTeamLead)
                .mapToDouble(emp -> emp.getSalary().getBruttoMonthly())
                .max().getAsDouble();
        System.out.println(maxGrossSalLead + " is the highest gross salary of the leads");


    }

    public static void main(String[] args) {

        findCEOV1();
        findCEOV2();
        employeeSalary();
        employeeSalaryAscV1();
        employeeSalaryAscV2();
        showDepartmentsV1();
        showDepartmentsV2();
        averageSalaryPerGender();
        departmentGenders();
        rangeOfSalary();

        System.out.println("-------------------");
    }

}
