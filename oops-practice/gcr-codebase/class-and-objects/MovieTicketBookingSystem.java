class MovieTicket {
	String movieName;
	String seatNumber;
	double price;
	boolean isBooked = false;

	public void bookTicket(String movieName, String seatNumber, double price) {
		if (isBooked) {
			System.err.println("House full!!! sorry..... Ticket already booked");
		} else {
			this.movieName = movieName;
			this.seatNumber = seatNumber;
			this.price = price;
			isBooked = true;
			displayTicketDetails();
		}
	}

	public void displayTicketDetails() {
		if (!isBooked) {
			System.out.println("Ticket have not booked yet....");
		} else {
			System.out.println("Ticket booked for movie: " + movieName);
			System.out.println("Seat Number: " + seatNumber);
			System.out.println("Price: $" + price);
		}
	}
}

public class MovieTicketBookingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieTicket ticket = new MovieTicket();
		ticket.displayTicketDetails();
		ticket.bookTicket("Dragon", "A10", 120.0);
		ticket.bookTicket("Dragon", "A10", 120.0);
        ticket.bookTicket("Dragon", "A10", 120.0);
        ticket.displayTicketDetails();
	}

}