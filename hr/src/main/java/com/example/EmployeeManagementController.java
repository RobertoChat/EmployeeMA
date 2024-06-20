package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Die Klasse EmployeeManagementController steuert die GUI und die Interaktionen mit dem EmployeeManagerService.
 */
public class EmployeeManagementController {

    // Instanz des EmployeeManagerService
    private final EmployeeManagerService employeeManagerService = new EmployeeManagerService();

    // Model für die JList zur Anzeige der Mitarbeiter
    private final DefaultListModel<Employee> employeeListModel = new DefaultListModel<>();

    // JList zur Anzeige der Mitarbeiter
    private final JList<Employee> employeeList = new JList<>(employeeListModel);

    // Hauptfenster der Anwendung
    private final JFrame frame = new JFrame("Employee Management");

    // Buttons zum Hinzufügen und Löschen von Mitarbeitern
    private final JButton addButton = new JButton("Add Employee");
    private final JButton deleteButton = new JButton("Delete Employee");

    public EmployeeManagementController() {
        initUI();
        initListeners();
    }

    private void initUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel label = new JLabel("Employee List", SwingConstants.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        frame.add(label, BorderLayout.NORTH);
        frame.add(new JScrollPane(employeeList), BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Set initial size and minimum size
        frame.setSize(400, 300);
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Laden der Mitarbeiterliste beim Start
        refreshEmployeeList();
    }

    private void initListeners() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel = new JPanel(new GridLayout(3, 2));
                JTextField firstNameField = new JTextField();
                JTextField lastNameField = new JTextField();
                panel.add(new JLabel("First Name:"));
                panel.add(firstNameField);
                panel.add(new JLabel("Last Name:"));
                panel.add(lastNameField);

                int option = JOptionPane.showConfirmDialog(frame, panel, "Enter employee name", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (option == JOptionPane.OK_OPTION) {
                    String firstName = firstNameField.getText();
                    String lastName = lastNameField.getText();
                    if (!firstName.isEmpty() && !lastName.isEmpty()) {
                        int id = employeeManagerService.findAllEmployees().size() + 1;
                        Employee employee = new Employee(id, firstName, lastName, firstName.toLowerCase() + "." + lastName.toLowerCase() + "@ceo.education");
                        employeeManagerService.addEmployee(employee);
                        refreshEmployeeList();
                    } else {
                        JOptionPane.showMessageDialog(frame, "First name and last name are required.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Employee selectedEmployee = employeeList.getSelectedValue();
                if (selectedEmployee != null) {
                    employeeManagerService.deleteEmployee(selectedEmployee.getId());
                    refreshEmployeeList();
                }
            }
        });
    }

    private void refreshEmployeeList() {
        employeeListModel.clear();
        List<Employee> employees = employeeManagerService.findAllEmployees();
        for (Employee employee : employees) {
            employeeListModel.addElement(employee);
        }
        adjustFrameWidth();
    }

    /**
     * Passt die Breite des Fensters an die Breite des längsten Eintrags an.
     */
    private void adjustFrameWidth() {
        int maxWidth = getMaxListItemWidth();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int newWidth = Math.min(Math.max(maxWidth + 50, frame.getMinimumSize().width), screenSize.width); // 50 Pixel für Padding
        Dimension frameSize = frame.getSize();
        frame.setSize(new Dimension(newWidth, frameSize.height));
        frame.setLocationRelativeTo(null); // Zentriert das Fenster erneut
    }

    /**
     * Berechnet die maximale Breite der Einträge in der Liste.
     * @return die maximale Breite
     */
    private int getMaxListItemWidth() {
        int maxWidth = 0;
        ListModel<Employee> model = employeeList.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            Employee employee = model.getElementAt(i);
            FontMetrics metrics = employeeList.getFontMetrics(employeeList.getFont());
            int width = metrics.stringWidth(employee.toString());
            if (width > maxWidth) {
                maxWidth = width;
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(EmployeeManagementController::new);
    }
}
