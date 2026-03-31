package scenario_based.CabBookingSystem;

// Custom exception
public class NoDriverAvailableException extends Exception {

    public NoDriverAvailableException(String message) {
        super(message);
    }
}
