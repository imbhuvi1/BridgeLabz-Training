package scenario_based.HotelReservationSystem;

// Pricing abstraction
public interface PricingStrategy {

    double calculatePrice(double basePrice, int days);
}
