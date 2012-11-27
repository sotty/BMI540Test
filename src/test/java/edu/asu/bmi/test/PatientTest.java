package edu.asu.bmi.test;


import edu.asu.bmi.test.mock.MockEMR;
import edu.asu.bmi.test.model.Patient;
import edu.asu.bmi.test.model.impl.PatientImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;


public class PatientTest {

    private Patient p1;
    private Patient p2;

    @Before
    public void setUp() {
        p1 = new PatientImpl();
        p2 = new PatientImpl( MockEMR.pid, "Jane Doe" );
    }


    @Test
    public void testId() {
        assertNotNull( p1.getId() );
        assertNotNull( p2.getId() );

        assertEquals( MockEMR.pid, p2.getId() );

        assertFalse( p1.getId().equals( new PatientImpl().getId() ) );
    }

    @Test
    public void testName() {
        assertEquals( "Jane Doe", p2.getName() );
    }



}
