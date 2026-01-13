package scenario_based.ECommerceOrderManagementSystem;

public interface Payment {
    void pay(double amount) throws PaymentFailedException;
}
