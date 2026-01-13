package scenario_based.HospitalManagementSystem;

// Abstraction
public interface HospitalService {

    void bookAppointment(Appointment appointment) throws AppointmentNotAvailableException;
    void cancelAppointment(String timeSlot);
}
