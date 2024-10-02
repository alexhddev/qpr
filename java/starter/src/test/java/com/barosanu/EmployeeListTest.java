package com.barosanu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class EmployeeListTest {

    private EmployeeList employeeList;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;

    @BeforeEach
    void setUp() {
        employeeList = new EmployeeList();
        employee1 = new Employee("John Doe", 35, 55000);
        employee2 = new Employee("Jane Smith", 42, 65000);
        employee3 = new Employee("Bob Johnson", 28, 45000);
    }

    @Test
    void testAddEmployee() {
        employeeList.addEmployee(employee1);
        assertEquals(1, employeeList.getEmployees().size());
        assertTrue(employeeList.getEmployees().contains(employee1));
    }

    @Test
    void testRemoveEmployee() {
        employeeList.addEmployee(employee1);
        employeeList.addEmployee(employee2);
        employeeList.removeEmployee(employee1);
        assertEquals(1, employeeList.getEmployees().size());
        assertFalse(employeeList.getEmployees().contains(employee1));
        assertTrue(employeeList.getEmployees().contains(employee2));
    }

    @Test
    void testGetEmployeeNames() {
        employeeList.addEmployee(employee1);
        employeeList.addEmployee(employee2);
        String[] expectedNames = {"John Doe", "Jane Smith"};
        assertArrayEquals(expectedNames, employeeList.getEmployeeNames());
    }

    @Test
    void testGetEmployeesNamesWithStreams() {
        employeeList.addEmployee(employee1);
        employeeList.addEmployee(employee2);
        String[] expectedNames = {"John Doe", "Jane Smith"};
        assertArrayEquals(expectedNames, employeeList.getEmployeesNamesWithStreams());
    }

    @Test
    void testGetEmployeesSortedByAge() {
        employeeList.addEmployee(employee1);
        employeeList.addEmployee(employee2);
        employeeList.addEmployee(employee3);
        List<Employee> sortedEmployees = employeeList.getEmployeesSortedByAge();
        assertEquals(3, sortedEmployees.size());
        assertEquals(employee3, sortedEmployees.get(0));
        assertEquals(employee1, sortedEmployees.get(1));
        assertEquals(employee2, sortedEmployees.get(2));
    }

    @Test
    void testGetEmployeesWithSalaryGreaterThan() {
        employeeList.addEmployee(employee1);
        employeeList.addEmployee(employee2);
        employeeList.addEmployee(employee3);
        List<Employee> filteredEmployees = employeeList.getEmployeesWithSalaryGreaterThan(55000);
        assertEquals(1, filteredEmployees.size());
        assertTrue(filteredEmployees.contains(employee2));
    }

    @Test
    void testGetEmployeesWithSalaryGreaterThanSorted() {
        employeeList.addEmployee(employee1);
        employeeList.addEmployee(employee2);
        employeeList.addEmployee(employee3);
        List<Employee> filteredSortedEmployees = employeeList.getEmployeesWithSalaryGreaterThanSorted(40000);
        assertEquals(3, filteredSortedEmployees.size());
        assertEquals(employee3, filteredSortedEmployees.get(0));
        assertEquals(employee1, filteredSortedEmployees.get(1));
        assertEquals(employee2, filteredSortedEmployees.get(2));
    }
}
