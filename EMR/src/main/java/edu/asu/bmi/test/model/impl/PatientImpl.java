package edu.asu.bmi.test.model.impl;

import edu.asu.bmi.test.model.Patient;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.util.UUID;

@Entity
public class PatientImpl implements Patient {

    @Id
    @XmlAttribute
    private String mrn;

    @Basic
    @XmlElement
    private String name;

    @Basic
    @XmlElement
    private int age;


    public PatientImpl() {
        this.mrn = UUID.randomUUID().toString();
    }

    public PatientImpl( String mrn, String name, int age ) {
        this.mrn = mrn;
        this.name = name;
        this.age = age;
    }

    public PatientImpl( String id ) {
        this.mrn = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PatientImpl patient = (PatientImpl) o;

        if (mrn != null ? !mrn.equals(patient.mrn) : patient.mrn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return mrn != null ? mrn.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "PatientImpl{" +
               "mrn='" + mrn + '\'' +
               ", name='" + name + '\'' +
               ", age=" + age +
               '}';
    }

    public String getMrn() {
        return mrn;
    }

    public void setMrn(String mrn) {
        this.mrn = mrn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public static class XMLAdapter extends XmlAdapter<PatientImpl,Patient> {
        @Override
        public Patient unmarshal( PatientImpl v ) throws Exception {
            return v;
        }

        @Override
        public PatientImpl marshal( Patient v ) throws Exception {
            return (PatientImpl) v;
        }
    }
}
