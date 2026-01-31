
abstract class GoodsTransport {
	protected String transportId;
	protected String transportDate;
	protected int transportRating;

	GoodsTransport(String transportId, String transportDate, int transportRating) {
		setTransportId(transportId);
		setTransportDate(transportDate);
		setTransportRating(transportRating);
	}

	public String getTransportId() {
		return transportId;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	public String getTransportDate() {
		return transportDate;
	}

	public void setTransportDate(String transportDate) {
		this.transportDate = transportDate;
	}

	public int getTransportRating() {
		return transportRating;
	}

	public void setTransportRating(int transportRating) {
		this.transportRating = transportRating;
	}

	abstract public String vehicleSelection();

	abstract public float calculateTotalCharge();
}
