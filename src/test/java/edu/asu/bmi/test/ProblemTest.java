package edu.asu.bmi.test;


import edu.asu.bmi.test.model.Problem;
import edu.asu.bmi.test.model.impl.ProblemImpl;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ProblemTest {

    @Test
    public void testProblemConstruction() {
        String asthmaCode = "123-asthma";
        String pid = "xyz";

        Problem asthma = new ProblemImpl( asthmaCode, pid );

        assertEquals( asthmaCode, asthma.getProblemCode() );

        // no problem name was provided, so the code should have been used
        assertEquals( asthmaCode, asthma.getProblemName() );

        assertEquals( pid, asthma.getPatientId() );

        // the timestamp should have been set at the creation time, which should be before now!
        assertTrue( asthma.getDate().getTime() <= now() );
    }

    private long now() {
        return new Date().getTime();
    }

}
