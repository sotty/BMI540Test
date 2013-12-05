package edu.asu.bmi.test.factories;


import edu.asu.bmi.test.control.EMR;
import edu.asu.bmi.test.control.impl.EMRController;

public class EMRFactoryImpl implements EMRFactory {

    private static EMRFactory singleton = new EMRFactoryImpl();

    public static EMRFactory getInstance() {
        return singleton;
    }

    private EMRFactoryImpl() {

    }

    public EMR buildEMR() {
        return new EMRController();
    }

}
