package gcr_codebase.functional_interface;

interface PaymentService {
	void pay(double amount);

	default void refund(double amount) {
		System.out.println("Refunded " + amount + " amount");
	}
}

class PayTm implements PaymentService {
	@Override
	public void pay(double amount) {
		System.out.println("Payed " + amount + " PayTm");
	}
}

class PhonePe implements PaymentService {

	@Override
	public void pay(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Payed " + amount + " from PhonePe");
	}

	@Override
	public void refund(double amount) {
		System.out.println("Refunded " + amount + " from PhonePe");
	}

}

public class PaymentGatewayIntegration {

	public static void main(String[] args) {
		PaymentService paytm = new PayTm();
		PaymentService phonepe = new PhonePe();

		paytm.pay(1000);
		paytm.refund(500);

		phonepe.pay(1000);
		phonepe.refund(500);
	}

}