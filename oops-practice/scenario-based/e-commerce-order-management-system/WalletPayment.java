package scenario_based.ECommerceOrderManagementSystem;

public class WalletPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Wallet");
    }
}
