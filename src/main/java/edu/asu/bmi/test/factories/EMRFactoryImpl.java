package edu.asu.bmi.test.factories;


import edu.asu.bmi.test.model.EMR;
import edu.asu.bmi.test.model.impl.EMRImpl;

public class EMRFactoryImpl implements EMRFactory {

    public EMR buildEMR() {
        return new EMRImpl();
    }

}
