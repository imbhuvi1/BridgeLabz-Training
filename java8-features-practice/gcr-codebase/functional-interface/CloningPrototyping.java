package gcr_codebase.functional_interface;

import java.util.ArrayList;
import java.util.List;

class Product implements Cloneable {
	private String name;
	private double price;
	private List<String> features;

	public Product(String name, double price, List<String> features) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = price;
		this.features = new ArrayList<String>(features);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Product clone = (Product) super.clone();
		clone.features = new ArrayList<String>(this.features);
		return clone;
	}

	public void addFeature(String feature) {
		features.add(feature);
	}

	@Override
	public String toString() {
		return name + "| Price: " + price + "| Features: " + features;
	}
}

public class CloningPrototyping {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		List<String> features = new ArrayList<String>();
		features.add("HD");
		features.add("WiFi");

		Product original = new Product("Phone", 13000, features);
		Product clone = (Product) original.clone();
		clone.addFeature("BlueTooth");
		System.out.println("Original: " + original);
		System.out.println("Clone: " + clone);
	}

}
