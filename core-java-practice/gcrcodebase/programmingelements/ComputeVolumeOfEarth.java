package gcrcodebase.programmingelements;


public class ComputeVolumeOfEarth {

	public static void main(String[] args) {
		//Creating radiusOfEarthInKm variable to store 6378km im it.
		double radiusOfEarthInKm = 6378;
		
		//Creating radiusOfEarthInKm variable to store 6378Miles im it.(1 km = 0.621371miles)
		double radiusOfEarthInMiles = 6378 * 0.621371;

		//Creating volumeOfEarthInKm variable to compute volume of earth in Kilometers and store in it
		double volumeOfEarthInKm = (4/3) * Math.PI * Math.pow(radiusOfEarthInKm,3);
		
		//Creating volumeOfEarthInMiles variable to compute volume of earth in Miles and store in it
		double volumeOfEarthInMiles = (4/3) * Math.PI * Math.pow(radiusOfEarthInMiles,3);

		//Displaying the volume of earth as mentioned in question
		System.out.println("The volume of earth in cubic kilometer is "+ volumeOfEarthInKm + " and cubic miles is: "+ volumeOfEarthInMiles);
	} 

}
