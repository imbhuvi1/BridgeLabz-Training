
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Utility {
	public GoodsTransport parseDetails(String input) {
		String data[] = input.split(":");
		GoodsTransport goodsTransport = null;
		String transportId = data[0];
		String transportDate = data[1];
		int transportRating = Integer.parseInt(data[2]);
		String type = data[3];
		if (type.equalsIgnoreCase("bricktransport")) {
			goodsTransport = new BrickTransport(transportId, transportDate, transportRating, Float.parseFloat(data[4]),
					Integer.parseInt(data[5]), Float.parseFloat(data[6]));
		} else if (type.equalsIgnoreCase("timbertransport")) {
			goodsTransport = new TimberTransport(transportId, transportDate, transportRating, Float.parseFloat(data[4]),
					Float.parseFloat(data[5]), data[6], Float.parseFloat(data[7]));
		}
		return goodsTransport;
	}

	public boolean validateTransportId(String transportId) {
		String transportRegex = "^RTS\\d{3}[A-Z]$";
		Pattern pattern = Pattern.compile(transportRegex);
		Matcher matcher = pattern.matcher(transportId);
		if (!matcher.matches()) {
			System.out.println("Transport Id " + transportId + " is invalid");
			return false;
		}
		return true;
	}

	public String findObjectType(GoodsTransport goodsTransport) {
		if (goodsTransport instanceof BrickTransport) {
			return "BrickTransport";
		} else if (goodsTransport instanceof TimberTransport) {
			return "TimberTransport";
		}
		return "N/A";
	}
}