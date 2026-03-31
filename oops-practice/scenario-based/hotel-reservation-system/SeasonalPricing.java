package scenario_based.HotelReservationSystem;

// Seasonal pricing (peak season)
public class SeasonalPricing implements PricingStrategy {

    @Override
    public double calculatePrice(double basePrice, int days) {
        return basePrice * days * 1.5;
    }
}
