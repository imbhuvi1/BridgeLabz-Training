package scenario_based.HospitalManagementSystem;

// Custom exception
public class AppointmentNotAvailableException extends Exception {

    public AppointmentNotAvailableException(String message) {
        super(message);
    }
}
