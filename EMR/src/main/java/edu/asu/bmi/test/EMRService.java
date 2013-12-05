package edu.asu.bmi.test;


import edu.asu.bmi.test.model.Patient;
import edu.asu.bmi.test.model.impl.PatientImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Collection;



@WebService( serviceName = "EMRService",
             endpointInterface = "edu.asu.bmi.test.service.EMRServiceImpl",
             targetNamespace = "http://edu.asu.bmi.540/emr",
             portName="EMRServicePort",
             wsdlLocation = "META-INF/wsdl/EMRService.wsdl" )
public interface EMRService {

    /**
     *
     * @return  the list of existing patients' IDs
     */
    @WebMethod( action = "getPatientIDs" )
    public ArrayList<String> getPatientIDs();


    /**
     * Retrieves a patient's details, given the patient's ID
     *
     * @param patientId     the ID of the patient to be looked up
     * @return              the Patient
     * @see Patient
     */
    @WebMethod( action = "getPatientDetail" )
    public PatientImpl getPatientDetail( String patientId );


    /**
     * Creates a new Patient for a given name and age
     * @param patientName
     * @param age
     * @return the patient's ID
     * @see Patient
     */
    @WebMethod( action = "createPatient" )
    public String createPatient( String patientName, int age );


    /**
     * Deletes a patient
     * @param patientId
     */
    @WebMethod( action = "deletePatient" )
    public boolean deletePatient( String patientId );


    /**
     * Test method
     * @param in
     * @return
     */
    @WebMethod( action = "echo" )
    public String echo( String in );
}
