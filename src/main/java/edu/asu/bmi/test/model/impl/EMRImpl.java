package edu.asu.bmi.test.model.impl;


import edu.asu.bmi.test.model.EMR;
import edu.asu.bmi.test.model.Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EMRImpl implements EMR {

    private Map<String, List<Problem>> registry = new HashMap<String, List<Problem>>();

    public List<Problem> getProblemsByPatient( String patientId ) {
        if ( registry.containsKey( patientId ) ) {
            return Collections.unmodifiableList( registry.get( patientId ) );
        } else {
            return Collections.emptyList();
        }
    }

    public void recordProblem( String patientId, Problem problem ) {
        if ( ! patientId.equals( problem.getPatientId() ) ) {
            throw new IllegalStateException( "Error : trying to register problem " + problem + " in patientId " + patientId + " 's record." +
                    "The problem instead has been recorded for patient " + problem.getPatientId() );
        }
        if ( registry.containsKey( patientId ) ) {
            registry.get( patientId ).add( problem );
        } else {
            List<Problem> list = new ArrayList<Problem>();
            list.add( problem );
            registry.put( patientId, list );
        }
    }
}
