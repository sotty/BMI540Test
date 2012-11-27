package edu.asu.bmi.test;


import edu.asu.bmi.test.factories.EMRFactory;
import edu.asu.bmi.test.factories.EMRFactoryImpl;
import edu.asu.bmi.test.mock.MockEMR;
import edu.asu.bmi.test.mock.MockEMRFactory;
import edu.asu.bmi.test.mock.MockMain;
import edu.asu.bmi.test.model.EMR;
import edu.asu.bmi.test.model.Patient;
import edu.asu.bmi.test.model.Problem;
import edu.asu.bmi.test.model.impl.PatientImpl;
import edu.asu.bmi.test.model.impl.ProblemImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

public class ClientTest {


    private static EMRFactory factory;


    @BeforeClass
    public static void init() {
        // Being focused on a hypothetical client workflow, we use a mock EMR
        factory = new MockEMRFactory();

    }

    private Main main;

    @Before
    public void setupTest() {
        main = new MockMain();
        ((MockMain) main).setEMR(factory.buildEMR());
    }

    @Test
    public void testMainLookup() {
        // This is what a "main" application would probably do...
        // However, instead of using a "mock" main, one would test the real one :)

        // Get the patient id
        String id = MockEMR.pid;

        // Retrieve the patient
        Patient p = main.lookupPatient( id );

        assertNotNull( p );
        assertEquals( id, p.getId() );

        // And finally retrieve the patient's problems
        // We suppose that the patient had previous problems...
        List<Problem> problems = main.getEMR().getProblemsByPatient(p.getId());
        assertFalse(problems.isEmpty());

        // We add a new one
        main.registerProblem( p.getId(), "ashtma" );

        // and later check that it still exists. To do so, we use an equality check!
        problems = main.getEMR().getProblemsByPatient(p.getId());
        // i.e. does the record contain a problem which is equal to this one?
        // notice that pid and problemCode are "keys" for Problem...
        assertTrue( problems.contains( new ProblemImpl( "ashtma", p.getId() ) ) );

    }


}
