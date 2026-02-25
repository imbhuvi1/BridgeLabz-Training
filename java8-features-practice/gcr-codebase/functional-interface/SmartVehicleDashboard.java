package gcr_codebase.functional_interface;

interface DashBoard {
	void displaySpeed(double speed);

	default void displayBattery(double percentage) {
		System.out.println("Dosen't have a battery");
	}
}

class DieselVehicle implements DashBoard {

	@Override
	public void displaySpeed(double speed) {
		// TODO Auto-generated method stub
		System.out.println("Speed: " + speed + " km/hr");
	}

}

class ElectricVehicle implements DashBoard {

	@Override
	public void displaySpeed(double speed) {
		// TODO Auto-generated method stub
		System.out.println("Speed: " + speed + " km/hr");
	}

	@Override
	public void displayBattery(double percentage) {
		System.out.println("Battery: " + percentage);
	}
}

public class SmartVehicleDashboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DashBoard diesel = new DieselVehicle();
		DashBoard electric = new ElectricVehicle();

		diesel.displaySpeed(55.5);
		diesel.displayBattery(100);

		electric.displaySpeed(35.2);
		electric.displayBattery(73.2);
	}

}