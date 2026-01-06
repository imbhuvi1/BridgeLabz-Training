package gcr_codebase.encapsulation_polymorphism_interface_abstraction;

//Interface for discount related operations
interface Discountable {
  double applyDiscount();
  String getDiscountDetails();
}

//Abstract class representing a food item
abstract class FoodItem {
  private String itemName;
  private double price;
  private int quantity;

  //Constructor to initialize food item
  public FoodItem(String itemName, double price, int quantity) {
      this.itemName = itemName;
      this.price = price;
      this.quantity = quantity;
  }

  //Abstract method for calculating total price
  public abstract double calculateTotalPrice();

  //Concrete method to display item details
  public void getItemDetails() {
      System.out.println("Item Name: " + itemName);
      System.out.println("Price: " + price);
      System.out.println("Quantity: " + quantity);
  }

  //Protected getters to ensure encapsulation
  protected double getPrice() {
      return price;
  }

  protected int getQuantity() {
      return quantity;
  }
}

//Class representing vegetarian food item
class VegItem extends FoodItem implements Discountable {

  //Constructor for VegItem
  public VegItem(String itemName, double price, int quantity) {
      super(itemName, price, quantity);
  }

  //Override method to calculate total price
  @Override
  public double calculateTotalPrice() {
      return getPrice() * getQuantity();
  }

  //Apply discount on veg item
  @Override
  public double applyDiscount() {
      return calculateTotalPrice() * 0.10;
  }

  //Return discount details
  @Override
  public String getDiscountDetails() {
      return "10 percent discount on Veg items";
  }
}

//Class representing non vegetarian food item
class NonVegItem extends FoodItem implements Discountable {

  private static final double EXTRA_CHARGE = 50;

  //Constructor for NonVegItem
  public NonVegItem(String itemName, double price, int quantity) {
      super(itemName, price, quantity);
  }

  //Override method to calculate total price with extra charge
  @Override
  public double calculateTotalPrice() {
      return (getPrice() * getQuantity()) + EXTRA_CHARGE;
  }

  //Apply discount on non veg item
  @Override
  public double applyDiscount() {
      return calculateTotalPrice() * 0.05;
  }

  //Return discount details
  @Override
  public String getDiscountDetails() {
      return "5 percent discount on Non Veg items";
  }
}

//Main class for order processing
public class OnlineFoodDeliverySystem {

  //Polymorphic method to process any food item
  public static void processOrder(FoodItem item) {

      item.getItemDetails();
      double totalAmount = item.calculateTotalPrice();

      //Check and apply discount if applicable
      if (item instanceof Discountable) {
          Discountable discount = (Discountable) item;
          double discountAmount = discount.applyDiscount();
          System.out.println(discount.getDiscountDetails());
          totalAmount -= discountAmount;
      }

      System.out.println("Final Amount to Pay: " + totalAmount);
      System.out.println();
  }

  //Main method
  public static void main(String[] args) {

      FoodItem vegItem = new VegItem("Paneer Butter Masala", 200, 2);
      FoodItem nonVegItem = new NonVegItem("Chicken Biryani", 300, 1);

      processOrder(vegItem);
      processOrder(nonVegItem);
  }
}

