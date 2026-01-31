class BrickTransport extends GoodsTransport {

	private float brickSize;
	private int brickQuantity;
	private float brickPrice;

	public BrickTransport(String transportId, String transportDate, int transportRating, float brickSize,
			int brickQuantity, float brickPrice) {
		super(transportId, transportDate, transportRating);
		setBrickSize(brickSize);
		setBrickQuantity(brickQuantity);
		setBrickPrice(brickPrice);
	}

	public float getBrickSize() {
		return brickSize;
	}

	public void setBrickSize(float brickSize) {
		this.brickSize = brickSize;
	}

	public int getBrickQuantity() {
		return brickQuantity;
	}

	public void setBrickQuantity(int brickQuantity) {
		this.brickQuantity = brickQuantity;
	}

	public float getBrickPrice() {
		return brickPrice;
	}

	public void setBrickPrice(float brickPrice) {
		this.brickPrice = brickPrice;
	}

	@Override
	public String vehicleSelection() {
		// TODO Auto-generated method stub
		if (brickQuantity < 300) {
			return "Truck";
		}
		if (brickQuantity >= 300 && brickQuantity <= 500) {
			return "Lorry";
		}
		return "Monster Lorry";
	}

	@Override
	public float calculateTotalCharge() {
		// TODO Auto-generated method stub
		float price = brickQuantity * brickPrice;
		String vehicle = vehicleSelection();
		float vehiclePrice = 0;
		switch (vehicle) {
		case "Truck" -> vehiclePrice = 1000;
		case "Lorry" -> vehiclePrice = 1700;
		case "Monster Lorry" -> vehiclePrice = 3000;
		}
		float tax = price * 0.3f;
		float discount = 0;
		switch (transportRating) {
		case 5 -> discount = price * 0.2f;
		case 3, 4 -> discount = price * 0.1f;
		}
		float totalCharge = (price + vehiclePrice + tax) - discount;
		return totalCharge;
	}
}
