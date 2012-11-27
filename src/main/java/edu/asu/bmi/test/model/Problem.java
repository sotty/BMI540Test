package edu.asu.bmi.test.model;

import java.util.Date;

/**
 * A simple problem >>record<<
 *
 * The problem is recorded for a patient on a given date
 * The "name" and the "code" fully describe the problem,
 *
 */
public interface Problem {

    /**
     *
     * @return the problem's descriptive name
     */
    public String getProblemName();

    /**
     *
     * @return the problem type identifier
     */
    public String getProblemCode();

    /**
     *
     * @return the patient (id) for which this record has been created
     */
    public String getPatientId();

    /**
     *
     * @return the record's date
     */
    public Date getDate();

}
