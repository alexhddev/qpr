package com.barosanu;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList {

    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public String[] getEmployeeNames() {
        String[] names = new String[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            names[i] = employees.get(i).getName();
        }
        return names;
    }

    public String[] getEmployeesNamesWithStreams() {
        return employees.stream()
                .map(Employee::getName)
                .toArray(String[]::new);
    }

    public List<Employee> getEmployeesSortedByAge() {
        return employees.stream()
                .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .toList();
    }

    public List<Employee> getEmployeesWithSalaryGreaterThan(int salary) {
        return employees.stream()
                .filter(e -> e.getSalary() > salary)
                .toList();
    }

    public List<Employee> getEmployeesWithSalaryGreaterThanSorted(int salary) {

        return employees.stream()
                .filter(e -> e.getSalary() > salary)
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .toList();
    }

}
