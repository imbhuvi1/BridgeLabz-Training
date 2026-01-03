public class OnlineRetailOrder{
	public static void main(String[] args) {
		DeliveredOrder order = new DeliveredOrder(101, "03-01-2026", 14212, "05-01-2026");
		
		order.getOrderStatus();
	}
}

//base class
class Order{
	int orderId;
	String orderDate;
	
	//constructor of base class
	public Order(int orderId, String orderDate) {
		this.orderId = orderId;
		this.orderDate = orderDate;
	}
	
	//method to display details
	void getOrderStatus() {
		System.out.println("Order id: "+orderId);
		System.out.println("Order Date: "+orderDate);
	}
}

//class extending Order class
class ShippedOrder extends Order{
	int trackingNumber;
	
	//constructor of ShippedOrder class
	public ShippedOrder(int orderId, String orderDate, int trackingNumber) {
		super(orderId, orderDate);
		this.trackingNumber = trackingNumber;
	}
	
	@Override
	void getOrderStatus() {
		super.getOrderStatus();
		System.out.println("Tracking Number: "+trackingNumber);
	}
	
}

class DeliveredOrder extends ShippedOrder{
	String deliveryDate;
	
	public DeliveredOrder(int orderId, String orderDate, int trackingNumber, String deilveryDate) {
		super(orderId, orderDate,trackingNumber);
		this.deliveryDate = deliveryDate;
	}
	
	@Override
	void getOrderStatus() {
		super.getOrderStatus();
		System.out.println("Delivery Date:  "+deliveryDate);

	}
	
}