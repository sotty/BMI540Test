package edu.asu.bmi.test.control.impl;


import edu.asu.bmi.test.control.EMR;
import edu.asu.bmi.test.model.ModelFactory;
import edu.asu.bmi.test.model.ModelHome;
import edu.asu.bmi.test.model.Patient;
import edu.asu.bmi.test.model.impl.PatientImpl;


import java.util.Collection;

public class EMRController implements EMR {

    private ModelHome model;

    public EMRController() {
        this.model = new ModelHome();
    }

    @Override
    public Collection<String> getPatientIDs() {
        return model.getAll( PatientImpl.class, String.class, "mrn" );
    }

    @Override
    public Patient getPatientDetail( String patientId ) {
        return model.get( PatientImpl.class, patientId );
    }

    @Override
    public String createPatient( String patientName, int age ) {
        Patient pat = ModelFactory.createPatient( patientName, age );
        model.persist( pat );

        return pat.getMrn();
    }

    @Override
    public boolean deletePatient( String patientId ) {
        Patient p = getPatientDetail( patientId );
        if ( p == null ) {
            return false;
        }
        return model.delete( p );
    }


    public void dispose() {
        model.dispose();
    }

}
