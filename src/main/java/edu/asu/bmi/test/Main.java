package edu.asu.bmi.test;


import edu.asu.bmi.test.model.EMR;
import edu.asu.bmi.test.model.Patient;

public interface Main {

    public Patient lookupPatient( String patientId );

    public EMR getEMR();

    public void registerProblem( String patientId, String problemCode );
}
