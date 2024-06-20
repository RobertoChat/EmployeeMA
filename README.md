# EmployeeMA
Employee Management System

Diese Anwendung verwaltet Mitarbeiterdaten über eine grafische Benutzeroberfläche (GUI) und speichert die Daten in einer MySQL-Datenbank.

**Funktionen**

Die Anwendung bietet folgende Funktionen:

    Hinzufügen eines Mitarbeiters: Neue Mitarbeiter können mit Vorname und Nachname hinzugefügt werden. Die E-Mail-Adresse wird automatisch generiert.
    Anzeigen aller Mitarbeiter: Alle vorhandenen Mitarbeiter werden in einer Liste angezeigt.
    Löschen eines Mitarbeiters: Mitarbeiter können aus der Datenbank gelöscht werden, indem sie in der Liste ausgewählt und der Löschvorgang bestätigt wird.
    Aktualisieren der Mitarbeiterdaten: Vorname, Nachname und E-Mail-Adresse eines Mitarbeiters können aktualisiert werden.

**Komponenten**

Die Anwendung besteht aus mehreren Komponenten:

    BaseEntity und Employee-Klasse:
        BaseEntity: Definiert eine abstrakte Basisklasse für alle Entitäten mit einer ID-Eigenschaft.
        Employee: Repräsentiert einen Mitarbeiter mit Vorname, Nachname und E-Mail-Adresse.

    EmployeeDao und EmployeeDaoMySQL:
        EmployeeDao: Interface für die Datenbankoperationen mit Employee-Objekten.
        EmployeeDaoMySQL: Implementierung des EmployeeDao-Interfaces für MySQL-Datenbankoperationen.

    EmployeeManager und EmployeeManagerService:
        EmployeeManager: Enthält die Geschäftslogik für die Verwaltung von Mitarbeitern und verwendet EmployeeDao für Datenbankoperationen.
        EmployeeManagerService: Bietet Service-Methoden für die Benutzeroberfläche und nutzt EmployeeManager.

    EmployeeManagementController:
        Steuert die grafische Benutzeroberfläche (GUI) und die Interaktionen mit EmployeeManagerService.

**Verwendung**

Um die Anwendung zu starten, führen Sie die main-Methode in der Klasse EmployeeManagementController aus. Die Benutzeroberfläche wird gestartet und zeigt die Liste der vorhandenen Mitarbeiter an. Von hier aus können Sie neue Mitarbeiter hinzufügen oder bestehende Mitarbeiter löschen.

**Setup**

Vor dem Start der Anwendung stellen Sie sicher, dass eine MySQL-Datenbank vorhanden ist. Die Konfiguration erfolgt über die Konstanten JDBC_URL, JDBC_USER und JDBC_PASSWORD in der Klasse EmployeeDaoMySQL.
    Java SE Development Kit 8 oder höher
    MySQL-Datenbank

**Hinweise**

    GUI-Steuerung: Die Benutzeroberfläche bietet einfache Steuerelemente zum Hinzufügen und Löschen von Mitarbeitern.
    Fehlerbehandlung: Fehler beim Datenbankzugriff werden über Dialogfenster angezeigt.
    Automatische E-Mail-Generierung: Durch die Eingabe des NAmen und Vornamen wird eine Standard-E-Mail-Adresse generiert.

**Autoren**

Entwickelt von Roberto


