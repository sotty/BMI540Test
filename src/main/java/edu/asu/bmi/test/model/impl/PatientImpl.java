package edu.asu.bmi.test.model.impl;


import edu.asu.bmi.test.model.Patient;

import java.util.UUID;

public class PatientImpl implements Patient {

    private String id;
    private String name;

    public PatientImpl() {
        this.id = UUID.randomUUID().toString();
        this.name = "John Doe";
    }

    public PatientImpl(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientImpl patient = (PatientImpl) o;

        if (id != null ? !id.equals(patient.id) : patient.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "PatientImpl{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
