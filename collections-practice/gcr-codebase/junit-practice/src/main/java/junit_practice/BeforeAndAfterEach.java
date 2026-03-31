package junit_practice;

public class BeforeAndAfterEach {
	boolean connected = false;

	public void connect() {
		connected = true;
		System.out.println("Database connected");
	}

	public void disconnect() {
		connected = false;
		System.out.println("Database disconnected");
	}

	public boolean isConnected() {
		return connected;
	}
}
