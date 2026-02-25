package gcr_codebase.functional_interface;

interface Payment {
	void pay();
}

class UPI implements Payment {

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("Payed using UPI");
	}
}

class CreditCard implements Payment {

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("Payed using Credit Card");
	}
}

class Wallet implements Payment {

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println("Payed using Wallet");
	}
}

public class DigitalPaymentInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Payment upi = new UPI();
		Payment creditCard = new CreditCard();
		Payment wallet = new Wallet();
		upi.pay();
		creditCard.pay();
		wallet.pay();
	}

}
