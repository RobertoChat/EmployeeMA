package com.example;

import java.util.List;

/**
 * Die Klasse EmployeeManager dient als Service-Schicht zwischen der Benutzeroberfläche und dem Datenzugriff.
 * Sie beinhaltet die Geschäftslogik für die Verwaltung von Mitarbeitern und verwendet ein EmployeeDao-Objekt, um auf die Datenbank zuzugreifen.
 */
public class EmployeeManager {
    private final EmployeeDao employeeDao;


    //Konstruktor zum Erstellen eines EmployeeManager-Objekts.
    public EmployeeManager(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


     //Fügt einen neuen Mitarbeiter hinzu.
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    //Aktualisiert die Informationen eines vorhandenen Mitarbeiters.
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    //Löscht einen Mitarbeiter anhand seiner ID.
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    /**
     * Sucht einen Mitarbeiter anhand seiner ID.
     * @return das gefundene Employee-Objekt oder null, wenn kein Mitarbeiter mit der gegebenen ID gefunden wurde
     */
    public Employee findEmployeeById(int id) {
        return employeeDao.findEmployeeById(id);
    }

    /**
     * Gibt eine Liste aller Mitarbeiter zurück.
     * @return eine Liste von Employee-Objekten, die alle Mitarbeiter repräsentieren
     */
    public List<Employee> findAllEmployees() {
        return employeeDao.findAllEmployees();
    }
}
