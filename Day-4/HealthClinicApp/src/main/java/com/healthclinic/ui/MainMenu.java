package com.healthclinic.ui;

import com.healthclinic.dto.Patient;
import com.healthclinic.service.PatientService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.healthclinic.exception.*;

public class MainMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final PatientService patientService = new PatientService();

    public void start() {

        while (true) {

            System.out.println("\n -- HEALTH CLINIC MANAGEMENT SYSTEM --");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patient");
            System.out.println("3. View All Patients");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPatient();
                    break;

                case 2 :
                    viewPatientById();
                    break;
                case 3:
                    viewAllPatients();
                    break;
                case 4:
                    updatePatient();
                    break;
                case 5:
                    deletePatient();
                    break;
                case 6:
                    System.out.println("Thank You!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }

        }

    }
    private void addPatient() {

        Patient patient = new Patient();

        System.out.print("First Name : ");
        patient.setFirstName(scanner.nextLine());

        System.out.print("Last Name : ");
        patient.setLastName(scanner.nextLine());

        System.out.print("Gender : ");
        patient.setGender(scanner.nextLine());

        System.out.print("Date of Birth (yyyy-mm-dd): ");
        patient.setDob(LocalDate.parse(scanner.nextLine()));

        System.out.print("Phone Number : ");
        patient.setPhoneNumber(scanner.nextLine());

        System.out.print("Email : ");
        patient.setEmail(scanner.nextLine());

        System.out.print("Address : ");
        patient.setAddress(scanner.nextLine());


        try{
            boolean added = patientService.addPatient(patient);

            if (added) {
                System.out.println("Patient Added Successfully");
            }
        }catch(ResourceNotFoundException | ValidationExpection e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Something went wrong");
        }
    }

    private void viewAllPatients() {

        List<Patient> patients = patientService.getAllPatients();

        if (patients.isEmpty()) {
            System.out.println("No Patients Found.");
            return;
        }

        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    private void viewPatientById() {

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientService.getPatientById(patientId);

        if (patient != null) {
            System.out.println(patient);
        } else {
            throw new ResourceNotFoundException("Patient not found");
        }
    }

    private void updatePatient() {

        Patient patient = new Patient();

        System.out.print("Enter Patient ID: ");
        patient.setPatientId(scanner.nextInt());
        scanner.nextLine();

        System.out.print("Enter First Name: ");
        patient.setFirstName(scanner.nextLine());

        System.out.print("Enter Last Name: ");
        patient.setLastName(scanner.nextLine());

        System.out.print("Enter Gender: ");
        patient.setGender(scanner.nextLine());

        System.out.print("Enter DOB (yyyy-mm-dd): ");
        patient.setDob(LocalDate.parse(scanner.nextLine()));

        System.out.print("Enter Phone Number: ");
        patient.setPhoneNumber(scanner.nextLine());

        System.out.print("Enter Email: ");
        patient.setEmail(scanner.nextLine());

        System.out.print("Enter Address: ");
        patient.setAddress(scanner.nextLine());


        try{
            boolean updated = patientService.updatePatient(patient);

            if (updated) {
                System.out.println("Patient Updated Successfully");
            }
        }catch(ResourceNotFoundException | ValidationExpection e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println("Something went wrong");
        }
    }

    private void deletePatient() {

        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        try{
            boolean deleted = patientService.deletePatient(patientId);

            if (deleted) {
                System.out.println("Patient Deleted Successfully");
            }
        }catch (ValidationExpection | ResourceNotFoundException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("Something went wrong");
        }
    }

}
