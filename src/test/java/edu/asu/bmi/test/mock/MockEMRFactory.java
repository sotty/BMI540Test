package edu.asu.bmi.test.mock;


import edu.asu.bmi.test.factories.EMRFactory;
import edu.asu.bmi.test.model.EMR;

public class MockEMRFactory implements EMRFactory {

    public EMR buildEMR() {
        return new MockEMR();
    }

}
