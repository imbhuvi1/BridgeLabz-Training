
import java.util.*;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Utility utility = new Utility();
		System.out.println("Enter the Goods Transport details");
		String input = sc.nextLine();
		String transportId = input.split(":")[0];
		if (!utility.validateTransportId(transportId)) {
			System.out.println("Please provide valid record");
			return;
		}
		GoodsTransport goodsTransport = utility.parseDetails(input);
		String type = utility.findObjectType(goodsTransport);
		System.out.println("Transport id : " + goodsTransport.getTransportId());
		System.out.println("Date of transport : " + goodsTransport.getTransportDate());
		System.out.println("Rating of the transport : " + goodsTransport.getTransportRating());
		if (type.equals("BrickTransport")) {
			BrickTransport brickTransport = (BrickTransport) goodsTransport;
			System.out.println("Quantity of bricks : " + brickTransport.getBrickQuantity());
			System.out.println("Brick price : " + brickTransport.getBrickPrice());
			System.out.println("Vehicle for transport : " + brickTransport.vehicleSelection());
			System.out.println("Total charge : " + brickTransport.calculateTotalCharge());
		} else {
			TimberTransport timberTransport = (TimberTransport) goodsTransport;
			System.out.println("Type of the timber : " + timberTransport.getTimberType());
			System.out.println("Timber price per kilo : " + timberTransport.getTimberPrice());
			System.out.println("Vehicle for transport : " + timberTransport.vehicleSelection());
			System.out.println("Total charge : " + timberTransport.calculateTotalCharge());
		}
	}

}