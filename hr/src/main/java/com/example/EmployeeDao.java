package com.example;

import java.util.List;

/**
 * EmployeeDao Interface für die Datenbankoperationen mit Employee-Objekten
 */

public interface EmployeeDao {

    // Methode zum Hinzufügen eines Employees in die Datenbank
    void addEmployee(Employee employee);

    // Methode zum Aktualisieren eines Employees in der Datenbank
    void updateEmployee(Employee employee);

    // Methode zum Löschen eines Employees aus der Datenbank anhand seiner ID
    void deleteEmployee(int id);

    // Methode zum Suchen eines Employees in der Datenbank anhand seiner ID
    Employee findEmployeeById(int id);

    // Methode zum Abrufen aller Employees aus der Datenbank
    List<Employee> findAllEmployees();
}
