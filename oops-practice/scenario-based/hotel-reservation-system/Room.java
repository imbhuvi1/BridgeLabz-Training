package scenario_based.HotelReservationSystem;

// Base Room class
public abstract class Room {

    protected int roomNumber;
    protected boolean available = true;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void checkIn() {
        available = false;
    }

    public void checkOut() {
        available = true;
    }

    // polymorphic pricing
    public abstract double getBasePrice();
}
