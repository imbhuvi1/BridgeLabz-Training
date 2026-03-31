package scenario_based.CabBookingSystem;

// Peak hour pricing
public class PeakFareCalculator implements FareCalculator {

    @Override
    public double calculateFare(double distance) {
        return distance * 15; // ₹15 per km
    }
}
