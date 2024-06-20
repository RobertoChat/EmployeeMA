package com.example;

/**
 * Die Klasse BaseEntity stellt eine abstrakte Basisklasse dar, die eine gemeinsame ID-Eigenschaft für alle Entitäten definiert.
*/

public abstract class BaseEntity {
    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}