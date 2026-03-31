class MobilePhone {
	String brand;
	String model;
	double price;

	public MobilePhone(String brand, String model, double price) {
		// TODO Auto-generated constructor stub
		this.brand = brand;
		this.model = model;
		this.price = price;
	}

	public void displayDetails() {
		System.out.println("Brand of mobile: " + brand);
		System.out.println("Model of mobile: " + model);
		System.out.println("Price of mobile: " + price);
		System.out.println("------------------------------");
	}
}

public class HandleMobilePhoneDetails {
	public static void main(String[] args) {
		MobilePhone mob1 = new MobilePhone("VIVO", "VIVO V29", 15999);
		MobilePhone mob2 = new MobilePhone("ONE PLUS", "ONE PLUS nor4", 39999);
		MobilePhone mob3 = new MobilePhone("APPLE", "iphone pro16", 79999);
		mob1.displayDetails();
		mob2.displayDetails();
		mob3.displayDetails();
	}

}