package com.healthclinic.dto;

import java.time.LocalDate;

public class VisitHistory {

    private int visitId;
    private int patientId;
    private int doctorId;
    private LocalDate visitDate;
    private String diagnosis;
    private String prescription;
    private String notes;

    public VisitHistory() {
    }

    public VisitHistory(int visitId, int patientId, int doctorId,
                        LocalDate visitDate,
                        String diagnosis,
                        String prescription,
                        String notes) {
        this.visitId = visitId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.notes = notes;
    }

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "\nVisit ID : " + visitId +
                "\nPatient ID : " + patientId +
                "\nDoctor ID : " + doctorId +
                "\nVisit Date : " + visitDate +
                "\nDiagnosis : " + diagnosis +
                "\nPrescription : " + prescription +
                "\nNotes : " + notes;
    }
}