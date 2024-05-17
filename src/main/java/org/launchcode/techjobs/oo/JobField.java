package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    private int id;
    private static int nextId = 1;
    public String value;

    //Code Constructors
    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public static int getNextId() {
        return nextId;
    }

    public String getValue() {
        return value;
    }

    //Equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return id == jobField.id && Objects.equals(value, jobField.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

    //Commonly used toString method
    @Override
    public String toString() {
        return value;
    }
}


