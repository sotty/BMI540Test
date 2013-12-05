package edu.asu.bmi.test.model;


import edu.asu.bmi.test.model.impl.PatientImpl;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

/**
 * A simple Patient class...
 * with an ID (unique) and a name
 * the Patient may suffer from some problems.
 *
 */
@XmlJavaTypeAdapter( PatientImpl.XMLAdapter.class )
public interface Patient {

    /**
     *
     * @return the Patient's ID
     */
    public String getMrn();

    /**
     *
     * @return the Patient's name
     */
    public String getName();


    /**
     *
     * @return the Patient's age
     */
    public int getAge();

}
