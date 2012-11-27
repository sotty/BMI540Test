package edu.asu.bmi.test;


import edu.asu.bmi.test.factories.EMRFactory;
import edu.asu.bmi.test.factories.EMRFactoryImpl;
import edu.asu.bmi.test.model.EMR;
import edu.asu.bmi.test.model.Problem;
import edu.asu.bmi.test.model.impl.ProblemImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class EMRTest {

    // Some mock identifiers
    private static final String pid1 = "p1";
    private static final String pid2 = "p2";
    private static final String pid3 = "p3";

    private static final String code1 = "abc";
    private static final String code2 = "def";


    private static EMRFactory factory;

    @BeforeClass
    public static void init() {
        // The factory gets created once and for all
        factory = new EMRFactoryImpl();
    }


    @Test
    public void testRetrieval() {
        // Create some random data and make sure they are retrieved correctly...

        Problem p1 = new ProblemImpl( code1, pid1 );
        Problem p2 = new ProblemImpl( code2, pid1 );
        Problem p3 = new ProblemImpl( code2, pid2 );

        EMR emr = factory.buildEMR();

        emr.recordProblem( pid1, p1 );
        emr.recordProblem( pid1, p2 );
        emr.recordProblem( pid2, p3 );

        assertEquals( 2, emr.getProblemsByPatient( pid1 ).size() );
        assertEquals( 1, emr.getProblemsByPatient( pid2 ).size() );
        assertEquals( 0, emr.getProblemsByPatient( pid3 ).size() );

        List<Problem> problemsOfP1 = emr.getProblemsByPatient( pid1 );
        assertTrue( problemsOfP1.contains( p1 ) );
        assertTrue( problemsOfP1.contains( p2 ) );
    }

    @Test( expected = IllegalStateException.class )
    public void testInconsistency() {
        // Force an inconsistency, and catch it!
        Problem p1 = new ProblemImpl( code1, pid1 );
        EMR emr = factory.buildEMR();

        // This should throw an exception, which is expected
        emr.recordProblem( pid2, p1 );

    }

}
