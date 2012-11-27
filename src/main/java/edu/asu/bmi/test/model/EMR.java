package edu.asu.bmi.test.model;


import java.util.List;


/**
 *  A simple EMR, which can only record patients' problems.
 *
 */
public interface EMR {

    /**
     *
     * @param patientId
     * @return  the list of a patient's known problem records
     */
    public List<Problem> getProblemsByPatient( String patientId );

    /**
     * Records a patient's problem
     *
     * Constraint : the problem's patientId has to be the same as the patientId arg
     *
     * @param patientId
     * @param problem   the problem to be recorded
     */
    public void recordProblem( String patientId, Problem problem );

}
