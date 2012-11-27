package edu.asu.bmi.test.mock;


import edu.asu.bmi.test.Main;
import edu.asu.bmi.test.model.EMR;
import edu.asu.bmi.test.model.Patient;
import edu.asu.bmi.test.model.impl.PatientImpl;
import edu.asu.bmi.test.model.impl.ProblemImpl;

public class MockMain implements Main {

    private EMR emr;

    public MockMain() {

    }

    public EMR getEMR() {
        return emr;
    }

    public void setEMR(EMR emr) {
        this.emr = emr;
    }

    public Patient lookupPatient( String patientId ) {
        return new PatientImpl( patientId, "John Doe" );
    }


    public void registerProblem(String patientId, String problemCode) {
        emr.recordProblem( patientId, new ProblemImpl( problemCode, patientId ) );
    }
}
