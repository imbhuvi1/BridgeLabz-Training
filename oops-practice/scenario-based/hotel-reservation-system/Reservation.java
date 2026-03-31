package scenario_based.HotelReservationSystem;

// Reservation entity
public class Reservation {

    private Guest guest;
    private Room room;
    private int days;
    private double totalAmount;

    public Reservation(Guest guest, Room room, int days) {
        this.guest = guest;
        this.room = room;
        this.days = days;
    }

    public void setTotalAmount(double amount) {
        this.totalAmount = amount;
    }

    public void displayInvoice() {
        System.out.println("Guest: " + guest.getName());
        System.out.println("Room No: " + room.roomNumber);
        System.out.println("Days: " + days);
        System.out.println("Total Bill: ₹" + totalAmount);
    }
}
