package com.example;

import java.util.List;

/**
 * Implementiert einen Service für die Verwaltung von Employees, indem er den EmployeeManager verwendet, der wiederum auf die EmployeeDaoMySQL zugreift.
 */

public class EmployeeManagerService {

    // EmployeeManager für die Verwaltung von Employees und die Datenbankoperationen
    private final EmployeeManager employeeManager = new EmployeeManager(new EmployeeDaoMySQL());

    // Methode zum Hinzufügen eines Employees
    public void addEmployee(Employee employee) {
        employeeManager.addEmployee(employee); // Ruft die entsprechende Methode im EmployeeManager auf
    }

    // Methode zum Aktualisieren eines Employees
    public void updateEmployee(Employee employee) {
        employeeManager.updateEmployee(employee); // Ruft die entsprechende Methode im EmployeeManager auf
    }

    // Methode zum Löschen eines Employees anhand seiner ID
    public void deleteEmployee(int employeeId) {
        employeeManager.deleteEmployee(employeeId); // Ruft die entsprechende Methode im EmployeeManager auf
    }

    // Methode zum Abrufen aller Employees
    public List<Employee> findAllEmployees() {
        return employeeManager.findAllEmployees(); // Ruft die entsprechende Methode im EmployeeManager auf
    }

    // Methode zum Suchen eines Employees anhand seiner ID
    public Employee findEmployeeById(int id) {
        return employeeManager.findEmployeeById(id); // Ruft die entsprechende Methode im EmployeeManager auf
    }
}
