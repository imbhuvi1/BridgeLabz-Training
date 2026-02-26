package com.json.practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
	private String vehicleNumber;
	private String model;

	public Car(String vehicleNumber, String model) {
		this.vehicleNumber = vehicleNumber;
		this.model = model;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}

public class CarToJson {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		Car car = new Car("1234", "Benz");
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(car);
		System.out.println(json);
	}

}