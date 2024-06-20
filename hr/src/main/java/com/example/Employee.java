package com.example;

/**
 * Die Klasse Employee repräsentiert einen Mitarbeiter mit Vorname, Nachname und E-Mail-Adresse.
 * Sie erbt von der abstrakten Klasse BaseEntity, die eine ID für Entitäten definiert.
 */
public class Employee extends BaseEntity {
    private String firstName;  // Vorname des Mitarbeiters
    private String lastName;   // Nachname des Mitarbeiters
    private String email;      // E-Mail-Adresse des Mitarbeiters

    //Konstruktor für die Erstellung eines Employee-Objekts mit einer ID, Vorname, Nachname und E-Mail-Adresse.
    public Employee(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //Konstruktor für die Erstellung eines Employee-Objekts mit Vorname und Nachname. E-Mail-Adresse wird automatisch generiert.
    public Employee(String firstName, String lastName) {
        super();  // Aufruf des Standardkonstruktors der Basisklasse BaseEntity
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@ceo.education";
    }

    // Getter und Setter für die Attribute
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Ausgabe
    @Override
    public String toString() {
        return "Employee ID: " + id + ", firstname: " + firstName + ", lastname: " + lastName + ", email: " + email;
    }
}
