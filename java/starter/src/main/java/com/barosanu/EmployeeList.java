package com.barosanu;

import java.util.ArrayList;
import java.util.List;
/**
 * The EmployeeList class represents a collection of Employee objects and provides
 * various operations to manage and retrieve employee data.
 */
public class EmployeeList {

    /**
     * A list to store Employee objects.
     */
    private List<Employee> employees = new ArrayList<>();

    /**
     * Returns the list of all employees.
     *
     * @return A List containing all Employee objects.
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Adds a new employee to the list.
     *
     * @param employee The Employee object to be added.
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Removes an employee from the list.
     *
     * @param employee The Employee object to be removed.
     */
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    /**
     * Retrieves an array of employee names.
     *
     * @return An array of Strings containing the names of all employees.
     */
    public String[] getEmployeeNames() {
        String[] names = new String[employees.size()];
        for (int i = 0; i < employees.size(); i++) {
            names[i] = employees.get(i).getName();
        }
        return names;
    }

    /**
     * Retrieves an array of employee names using Java streams.
     *
     * @return An array of Strings containing the names of all employees.
     */
    public String[] getEmployeesNamesWithStreams() {
        return employees.stream()
                .map(Employee::getName)
                .toArray(String[]::new);
    }

    /**
     * Returns a list of employees sorted by age in ascending order.
     *
     * @return A List of Employee objects sorted by age.
     */
    public List<Employee> getEmployeesSortedByAge() {
        return employees.stream()
                .sorted((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()))
                .toList();

    }

    /**
     * Retrieves a list of employees with salary greater than the specified amount.
     *
     * @param salary The salary threshold.
     * @return A List of Employee objects with salary greater than the specified amount.
     */
    public List<Employee> getEmployeesWithSalaryGreaterThan(int salary) {
        return 
                employees.stream()
                        .filter(e -> e.getSalary() > salary)
                        .toList();
    }

    /**
     * Retrieves a list of employees with salary greater than the specified amount,
     * sorted by salary in ascending order.
     *
     * @param salary The salary threshold.
     * @return A List of Employee objects with salary greater than the specified amount,
     *         sorted by salary.
     */
    public List<Employee> getEmployeesWithSalaryGreaterThanSorted(int salary) {
        return employees.stream()
                .filter(e -> e.getSalary() > salary)
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .toList();
    }
}
