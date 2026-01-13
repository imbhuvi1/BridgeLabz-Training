package scenario_based.HospitalManagementSystem;

// Appointment entity
public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private String timeSlot;

    public Appointment(Patient patient, Doctor doctor, String timeSlot) {
        this.patient = patient;
        this.doctor = doctor;
        this.timeSlot = timeSlot;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void displayAppointment() {
        System.out.println("Patient: " + patient.name);
        System.out.println("Doctor: " + doctor.name);
        System.out.println("Time Slot: " + timeSlot);
        System.out.println("Consultation Fee: ₹" + doctor.calculateFee());
    }
}
