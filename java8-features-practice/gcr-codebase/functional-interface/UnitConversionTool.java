package gcr_codebase.functional_interface;

interface UnitConversion {
	static double kmToMiles(double km) {
		return km * 0.621;
	}

	static double kgToPounds(double kg) {
		return kg * 2.2;
	}
}

public class UnitConversionTool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("10 km to Miles: " + UnitConversion.kmToMiles(10));
		System.out.println("100 kg to Pounds: " + UnitConversion.kgToPounds(100));
	}

}
