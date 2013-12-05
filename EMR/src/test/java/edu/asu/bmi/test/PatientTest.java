package edu.asu.bmi.test;


import edu.asu.bmi.test.model.ModelFactory;
import edu.asu.bmi.test.model.Patient;
import edu.asu.bmi.test.model.impl.PatientImpl;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;


public class PatientTest {

    private Patient p1;
    private Patient p2;

    private static final String testId = "12345-6";

    @Before
    public void setUp() {
        p1 = ModelFactory.createPatient();
        p2 = ModelFactory.createPatient( testId, "Jane Doe", 32 );
    }


    @Test
    public void testId() {
        assertNotNull( p1.getMrn() );
        assertNotNull( p2.getMrn() );

        assertEquals( testId, p2.getMrn() );

        assertFalse( p1.getMrn().equals( ModelFactory.createPatient().getMrn() ) );
    }

    @Test
    public void testName() {
        assertEquals( "Jane Doe", p2.getName() );
    }



}
