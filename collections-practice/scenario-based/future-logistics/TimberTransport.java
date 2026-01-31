
class TimberTransport extends GoodsTransport {
	private float timberLength;
	private float timberRadius;
	private String timberType;
	private float timberPrice;

	public TimberTransport(String transportId, String transportDate, int transportRating, float timberLength,
			float timberRadius, String timberType, float timberPrice) {
		super(transportId, transportDate, transportRating);
		setTimberLength(timberLength);
		setTimberRadius(timberRadius);
		setTimberType(timberType);
		setTimberPrice(timberPrice);
	}

	public float getTimberLength() {
		return timberLength;
	}

	public void setTimberLength(float timberLength) {
		this.timberLength = timberLength;
	}

	public float getTimberRadius() {
		return timberRadius;
	}

	public void setTimberRadius(float timberRadius) {
		this.timberRadius = timberRadius;
	}

	public String getTimberType() {
		return timberType;
	}

	public void setTimberType(String timberType) {
		this.timberType = timberType;
	}

	public float getTimberPrice() {
		return timberPrice;
	}

	public void setTimberPrice(float timberPrice) {
		this.timberPrice = timberPrice;
	}

	@Override
	public String vehicleSelection() {
		// TODO Auto-generated method stub
		float area = (float) (2 * 3.147f * timberRadius * timberLength);
		if (area < 250) {
			return "Truck";
		}
		if (area >= 250 && area <= 400) {
			return "Lorry";
		}
		return "Monster Lorry";
	}

	@Override
	public float calculateTotalCharge() {
		// TODO Auto-generated method stub
		float volume = (float) (3.147f * timberRadius * timberRadius * timberLength);
		float price = volume * timberPrice * (timberType.equalsIgnoreCase("Premium") ? 0.25f : 0.15f);
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