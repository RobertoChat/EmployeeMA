package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * EmployeeManagementSwingUI ist eine Swing-basierte Benutzeroberfläche für die Mitarbeiterverwaltung.
 * Sie zeigt eine Liste der Mitarbeiter an und ermöglicht das Hinzufügen und Löschen von Mitarbeitern.
 */
public class EmployeeManagementSwingUI {

    // EmployeeManagerService für die Geschäftslogik
    private final EmployeeManagerService employeeManagerService = new EmployeeManagerService();

    //Konstruktor der Klasse. Initialisiert die Benutzeroberfläche.
    public EmployeeManagementSwingUI() {
        initUI();
    }

    //Initialisiert die Benutzeroberfläche der Anwendung.
    private void initUI() {

        JFrame frame = new JFrame("Employee Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Employee List", SwingConstants.CENTER);

        // ListModel für die JList, die die Mitarbeiter anzeigt
        DefaultListModel<Employee> listModel = new DefaultListModel<>();
        JList<Employee> employeeList = new JList<>(listModel);

        JButton addButton = new JButton("Add Employee");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Eingabeaufforderung für den Namen
                JPanel panel = new JPanel(new GridLayout(3, 2));
                JTextField firstNameField = new JTextField();
                JTextField lastNameField = new JTextField();
                panel.add(new JLabel("First Name:"));
                panel.add(firstNameField);
                panel.add(new JLabel("Last Name:"));
                panel.add(lastNameField);

                // Dialog zur Eingabe der Mitarbeiterdaten
                int option = JOptionPane.showConfirmDialog(frame, panel, "Enter employee name", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (option == JOptionPane.OK_OPTION) {
                    String firstName = firstNameField.getText();
                    String lastName = lastNameField.getText();
                    if (!firstName.isEmpty() && !lastName.isEmpty()) {
                        // ID setzen: Einfache Inkrementierung basierend auf der aktuellen Größe der Mitarbeiterliste
                        int id = employeeManagerService.findAllEmployees().size() + 1;
                        Employee employee = new Employee(id, firstName, lastName, firstName.toLowerCase() + "." + lastName.toLowerCase() + "@ceo.education");
                        employeeManagerService.addEmployee(employee);
                        listModel.addElement(employee);
                    } else {    // Fehlermeldung bei Falscheingabe
                        JOptionPane.showMessageDialog(frame, "First name and last name are required.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // Button zum Löschen eines ausgewählten Mitarbeiters
        JButton deleteButton = new JButton("Delete Employee");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee selectedEmployee = employeeList.getSelectedValue();
                if (selectedEmployee != null) {
                    employeeManagerService.deleteEmployee(selectedEmployee.getId());
                    listModel.removeElement(selectedEmployee);
                }
            }
        });

        // Panel für die Anordnung der GUI-Komponenten
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);
        panel.add(new JScrollPane(employeeList), BorderLayout.CENTER);
        panel.add(addButton, BorderLayout.WEST);
        panel.add(deleteButton, BorderLayout.EAST);

        // Hinzufügen des Hauptpanels zum Frame
        frame.add(panel, BorderLayout.CENTER);

        // Einstellungen und Anzeigen des Frames
        frame.setSize(400, 300);  // Größe des Frames
        frame.setMinimumSize(new Dimension(400, 300)); // Mindestgröße des Frames
        frame.setLocationRelativeTo(null); // Zentriert den Frame auf dem Bildschirm
        frame.setVisible(true); // Macht den Frame sichtbar

        // Laden der Mitarbeiterliste beim Start der Anwendung
        listModel.addAll(employeeManagerService.findAllEmployees());
    }

    /**
     * Hauptmethode der Anwendung. Startet die Swing-Anwendung und initialisiert die Benutzeroberfläche.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(EmployeeManagementSwingUI::new);
    }
}
