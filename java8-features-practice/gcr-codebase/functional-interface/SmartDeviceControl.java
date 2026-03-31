package gcr_codebase.functional_interface;

interface State {

	void turnOn();

	void turnOff();
}

class Lights implements State {

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("Lights Turned On");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("Lights turned Off");
	}
}

class AC implements State {

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("AC Turned On");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("AC turned Off");
	}
}

class TV implements State {

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("TV Turned On");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("TV turned Off");
	}
}

public class SmartDeviceControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		State lights = new Lights();
		State ac = new AC();
		State tv = new TV();
		
		lights.turnOn();
		ac.turnOn();
		tv.turnOn();
		
		lights.turnOff();
		ac.turnOff();
		tv.turnOff();
	}

}
