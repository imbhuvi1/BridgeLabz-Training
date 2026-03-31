class Item {
	String itemCode;
	String itemName;
	double price;

	Item(String itemCode, String itemName, double price) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.price = price;
	}

	public void display() {
		System.out.println("Item Code : " + itemCode);
		System.out.println("Item Name : " + itemName);
		System.out.println("Price : " + price);
		System.out.println("--------------------------------");
	}

	public double calculateTotalPrice(int quantity) {
		return price * quantity;
	}
}

public class TrackInventory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item item1 = new Item("01AA", "Water bottle", 500.0);
		Item item2 = new Item("01BB", "Rice", 700.0);
		Item item3 = new Item("02AA", "blackboard", 400.0);
		item1.display();
		item2.display();
		item3.display();
		int quantity = 3;
		System.out.println(
				"Total cost of " + item1.itemName + " (Qty " + quantity + ") : " + item1.calculateTotalPrice(quantity));
	}

}