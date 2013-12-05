package edu.asu.bmi.test.persistence;


import edu.asu.bmi.test.control.EMR;
import edu.asu.bmi.test.control.impl.EMRController;
import edu.asu.bmi.test.factories.EMRFactoryImpl;
import edu.asu.bmi.test.model.Patient;
import edu.asu.bmi.test.service.EMRServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

public class TestAPIs {

    EMR emr;

    @Before
    public void initDB() {
        emr = EMRFactoryImpl.getInstance().buildEMR();
    }

    @After
    public void closeDB() {
        ((EMRController) emr).dispose();
    }



    @Test
    public void testAPI_Internals() {

        Collection<String> pids = emr.getPatientIDs();

        System.err.println( "\n\n" );
        System.err.println( "*****************************************");
        System.err.println( pids );
        System.err.println( "*****************************************" );

        assertEquals( Arrays.asList( "p-111", "p-222", "p-333" ), pids );

        Patient patient = emr.getPatientDetail( pids.iterator().next() );
        System.err.println( patient );
        System.err.println( "\n\n" );


        String pid = emr.createPatient( "jane doe", 43 );
        System.err.println( "Created patient with ID " + pid );
        Patient newPatient = emr.getPatientDetail( pid );
        System.err.println( newPatient );
        System.err.println( "\n\n" );

        emr.deletePatient( pid );
    }

    @Test
    public void testService() {
        System.out.println( new EMRServiceImpl().getPatientIDs() );
    }



}
