package gcr_codebase.functional_interface;

interface Vehicle {
	void rent(int days);

	void returnVehicle();
}

class Car implements Vehicle {

	@Override
	public void rent(int days) {
		// TODO Auto-generated method stub
		int rate = 1000;
		System.out.println("Rent is Rs " + (rate * days));
	}

	@Override
	public void returnVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Car Returned");
	}
}

class Bike implements Vehicle {

	@Override
	public void rent(int days) {
		// TODO Auto-generated method stub
		int rate = 800;
		System.out.println("Rent is Rs " + (rate * days));
	}

	@Override
	public void returnVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Bike Returned");
	}
}

class Bus implements Vehicle {

	@Override
	public void rent(int days) {
		// TODO Auto-generated method stub
		int rate = 1800;
		System.out.println("Rent is Rs " + (rate * days));
	}

	@Override
	public void returnVehicle() {
		// TODO Auto-generated method stub
		System.out.println("Bus Returned");
	}
}

public class MultiVehicleRentalSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle car = new Car();
		Vehicle bike = new Bike();
		Vehicle bus = new Bus();
		
		car.rent(5);
		bike.rent(3);
		bus.rent(2);
		
		car.returnVehicle();
		bike.returnVehicle();
		bus.returnVehicle();
	}

}
