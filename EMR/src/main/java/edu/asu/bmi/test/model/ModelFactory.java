package edu.asu.bmi.test.model;

import edu.asu.bmi.test.model.impl.PatientImpl;

import java.util.Date;

public class ModelFactory {

    /**
     * Creates a default implementation of Patient
     * @return
     */
    public static Patient createPatient() {
        return new PatientImpl( java.util.UUID.randomUUID().toString() );
    }

    /**
     * Creates an implementation of Patient with the given args
     *
     * @param mrn
     * @param name
     * @param age
     * @return
     */
    public static Patient createPatient( String mrn, String name, int age ) {
        return new PatientImpl( mrn, name, age );
    }

    /**
     * Creates an implementation of Patient with the given args,
     * assigning an ID in the process
     *
     * @param name
     * @param age
     * @return
     */
    public static Patient createPatient( String name, int age ) {
        PatientImpl pat = new PatientImpl();
        pat.setName( name );
        pat.setAge( age );
        return pat;
    }

}
