package edu.asu.bmi.test.model.impl;

import edu.asu.bmi.test.model.Problem;

import java.util.Date;

public class ProblemImpl implements Problem {

    private String problemName;
    private String problemCode;
    private String patientId;
    private Date   date;


    public ProblemImpl(String problemCode, String patientId) {
        this.problemCode = problemCode;
        this.patientId = patientId;
        this.problemName = problemCode;
        this.date = new Date();
    }

    public ProblemImpl(String problemName, String problemCode, String patientId, Date date) {
        this.problemName = problemName;
        this.problemCode = problemCode;
        this.patientId = patientId;
        this.date = date;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public String getProblemCode() {
        return problemCode;
    }

    public void setProblemCode(String problemCode) {
        this.problemCode = problemCode;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProblemImpl problem = (ProblemImpl) o;

        if (patientId != null ? !patientId.equals(problem.patientId) : problem.patientId != null) return false;
        if (problemCode != null ? !problemCode.equals(problem.problemCode) : problem.problemCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = problemCode != null ? problemCode.hashCode() : 0;
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProblemImpl{" +
                "problemName='" + problemName + '\'' +
                ", problemCode='" + problemCode + '\'' +
                ", patientId='" + patientId + '\'' +
                ", date=" + date +
                '}';
    }
}
