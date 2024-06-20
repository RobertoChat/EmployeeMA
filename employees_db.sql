-- Neue Datenbank erstellen
CREATE DATABASE employees_db;

-- Zur neuen Datenbank wechseln
USE employees_db;

-- Tabelle anlegen
CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    first_name VARCHAR(100),
    departement VARCHAR(100),
    email VARCHAR(100)
);

-- Neuen Benutzer erstellen
CREATE USER 'CEO'@'localhost' IDENTIFIED BY '1001';

-- Berechtigungen vergeben
GRANT ALL PRIVILEGES ON employees_db.* TO 'CEO'@'localhost';

-- Änderungen übernehmen
FLUSH PRIVILEGES;
