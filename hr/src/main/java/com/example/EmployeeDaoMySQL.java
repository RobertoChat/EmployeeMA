package com.example;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse EmployeeDaoMySQL implementiert das EmployeeDao-Interface und stellt Methoden bereit, um Employee-Objekte in der Datenbank zu verwalten.
 */
public class EmployeeDaoMySQL implements EmployeeDao {

    // JDBC-Verbindungsdaten
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/employees_db";
    private static final String JDBC_USER = "CEO";
    private static final String JDBC_PASSWORD = "1001";

    // SQL-Statements für CRUD-Operationen
    private static final String SQL_INSERT = "INSERT INTO employees (id, firstName, lastName, email) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE employees SET firstName = ?, lastName = ?, email = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM employees WHERE id = ?";
    private static final String SQL_FIND_BY_ID = "SELECT * FROM employees WHERE id = ?";
    private static final String SQL_FIND_ALL = "SELECT * FROM employees";

    /**
     * Stellt eine Verbindung zur Datenbank her.
     * @return eine Verbindung zur Datenbank
     * @throws SQLException falls ein SQL-Fehler auftritt
     */
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    @Override
    public void addEmployee(Employee employee) {
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL_INSERT)) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirstName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ein SQL-Fehler ist aufgetreten", "Fehler", JOptionPane.ERROR_MESSAGE);
        }

    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL_UPDATE)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getEmail());
            statement.setInt(4, employee.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ein SQL-Fehler ist aufgetreten", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void deleteEmployee(int id) {
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL_DELETE)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ein SQL-Fehler ist aufgetreten", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public Employee findEmployeeById(int id) {
        Employee employee = null;
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL_FIND_BY_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                employee = new Employee(id, firstName, lastName, email);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ein SQL-Fehler ist aufgetreten", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
        return employee;
    }

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(SQL_FIND_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String email = resultSet.getString("email");
                Employee employee = new Employee(id, firstName, lastName, email);
                employees.add(employee);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ein SQL-Fehler ist aufgetreten", "Fehler", JOptionPane.ERROR_MESSAGE);
        }
        return employees;
    }
}
