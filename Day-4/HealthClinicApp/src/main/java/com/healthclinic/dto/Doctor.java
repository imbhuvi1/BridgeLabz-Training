package com.healthclinic.dto;

public class Doctor {

    private int doctorId;
    private String firstName;
    private String lastName;
    private String specialization;
    private String department;
    private String roomNumber;

    public Doctor() {
    }

    public Doctor(int doctorId, String firstName, String lastName,
                  String specialization, String department,
                  String roomNumber) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.department = department;
        this.roomNumber = roomNumber;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "\nDoctor ID      : " + doctorId +
                "\nName           : " + firstName + " " + lastName +
                "\nSpecialization : " + specialization +
                "\nDepartment     : " + department +
                "\nRoom Number    : " + roomNumber +
                "\n";
    }
}