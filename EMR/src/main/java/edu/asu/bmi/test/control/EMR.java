package edu.asu.bmi.test.control;


import edu.asu.bmi.test.model.Patient;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.Collection;


/**
 *  A simple EMR, which can only record patients' problems.
 *
 */
public interface EMR {

    /**
     *
     * @return  the list of existing patients' IDs
     */
    @WebMethod( action = "getPatientIDs" )
    public Collection<String> getPatientIDs();


    /**
     * Retrieves a patient's details, given the patient's ID
     *
     * @param patientId     the ID of the patient to be looked up
     * @return              the Patient
     * @see edu.asu.bmi.test.model.Patient
     */
    @WebMethod( action = "getPatientDetail" )
    public Patient getPatientDetail( String patientId );


    /**
     * Creates a new Patient for a given name and age
     * @param patientName
     * @param age
     * @return the patient's ID
     * @see edu.asu.bmi.test.model.Patient
     */
    @WebMethod( action = "createPatient" )
    public String createPatient( String patientName, int age );


    /**
     * Removes the patient with the given ID
     * @param patientId
     */
    @WebMethod( action = "createPatient" )
    public boolean deletePatient( String patientId );

}
