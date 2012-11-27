package edu.asu.bmi.test.mock;


import edu.asu.bmi.test.model.EMR;
import edu.asu.bmi.test.model.Problem;
import edu.asu.bmi.test.model.impl.ProblemImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockEMR implements EMR {

    public static final String pid = "xyz";

    private List<Problem> list = new ArrayList<Problem>( Arrays.asList(
                    (Problem)
                    new ProblemImpl( "123-ashtma", pid ),
                    new ProblemImpl( "456-diabetes", pid )
            ) );

    public List<Problem> getProblemsByPatient( String patientId ) {
        return list;
    }

    public void recordProblem(String patientId, Problem problem) {
        list.add( problem );
    }
}
