package scenario_based.HospitalManagementSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HospitalService service = new HospitalServiceImpl();

        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String pname = sc.nextLine();

        Patient patient = new Patient(pid, pname);

        System.out.print("Enter Doctor ID: ");
        int did = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String dname = sc.nextLine();

        System.out.print("Is Specialist Doctor? (yes/no): ");
        String type = sc.nextLine();

        Doctor doctor;
        if (type.equalsIgnoreCase("yes")) {
            doctor = new SpecialistDoctor(did, dname, "Specialist");
        } else {
            doctor = new Doctor(did, dname, "General");
        }

        System.out.print("Enter Appointment Time Slot: ");
        String slot = sc.nextLine();

        Appointment appointment = new Appointment(patient, doctor, slot);

        try {
            service.bookAppointment(appointment);
            System.out.println("\nAppointment Booked Successfully");
            appointment.displayAppointment();
        } catch (AppointmentNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("\nAdd Medical Record: ");
        String record = sc.nextLine();
        patient.addMedicalRecord(record);

        patient.viewMedicalHistory();

        sc.close();
    }
}
