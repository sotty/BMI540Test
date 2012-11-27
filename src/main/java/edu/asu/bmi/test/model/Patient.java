package edu.asu.bmi.test.model;


/**
 * A simple patient class...
 * with an ID (unique) and a name
 *
 */
public interface Patient {

    /**
     *
     * @return the Patient's ID
     */
    public String getId();

    /**
     *
     * @return the Patient's name
     */
    public String getName();

}
