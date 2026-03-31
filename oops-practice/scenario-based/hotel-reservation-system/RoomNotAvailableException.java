package scenario_based.HotelReservationSystem;

// Custom exception
public class RoomNotAvailableException extends Exception {

    public RoomNotAvailableException(String message) {
        super(message);
    }
}
