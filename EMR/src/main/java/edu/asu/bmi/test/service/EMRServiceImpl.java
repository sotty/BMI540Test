package edu.asu.bmi.test.service;


import edu.asu.bmi.test.EMRService;
import edu.asu.bmi.test.control.EMR;
import edu.asu.bmi.test.factories.EMRFactoryImpl;
import edu.asu.bmi.test.model.ModelFactory;
import edu.asu.bmi.test.model.ModelHome;
import edu.asu.bmi.test.model.Patient;
import edu.asu.bmi.test.model.impl.PatientImpl;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Collection;


@WebService(  )
public class EMRServiceImpl implements EMRService {

    private EMR emr;

    public EMRServiceImpl() {
        this.emr = EMRFactoryImpl.getInstance().buildEMR();
    }

    @Override
    public ArrayList<String> getPatientIDs() {
        return new ArrayList<String>( emr.getPatientIDs() );
    }

    public void setPatientIDs( ArrayList<String> ids ) {}

    @Override
    public PatientImpl getPatientDetail( String patientId ) {
        return (PatientImpl) emr.getPatientDetail( patientId );
    }

    @Override
    public String createPatient( String patientName, int age ) {
        return emr.createPatient( patientName, age );
    }

    @Override
    public boolean deletePatient( String patientId ) {
        return emr.deletePatient( patientId );
    }

    @Override
    public String echo( String in ) {
        return in;
    }

}
