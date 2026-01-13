package scenario_based.HotelReservationSystem;

// Normal season pricing
public class NormalPricing implements PricingStrategy {

    @Override
    public double calculatePrice(double basePrice, int days) {
        return basePrice * days;
    }
}
