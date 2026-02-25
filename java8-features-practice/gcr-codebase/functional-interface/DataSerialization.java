package gcr_codebase.functional_interface;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SerialData implements Serializable {
	private String data;

	public SerialData(String data) {
		// TODO Auto-generated constructor stub
		this.data = data;
	}

	@Override
	public String toString() {
		return data;
	}
}

public class DataSerialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerialData serialData = new SerialData("Data");
		if (serialData instanceof Serializable) {
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.dat"))) {
				oos.writeObject(serialData);
				System.out.println("Serial serialized successfully!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.dat"))) {
			SerialData restoredUser = (SerialData) ois.readObject();
			System.out.println("Deserialized data: " + restoredUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}