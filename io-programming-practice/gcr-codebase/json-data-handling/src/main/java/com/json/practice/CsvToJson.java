package com.json.practice;

import java.io.BufferedReader;
import java.io.FileReader;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CsvToJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String csvFile = "src/data.csv";
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			ObjectMapper mapper = new ObjectMapper();
			ArrayNode jsonArray = mapper.createArrayNode();
			String line;
			String[] headers = br.readLine().split(",");
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				ObjectNode obj = mapper.createObjectNode();
				for (int i = 0; i < headers.length; i++) {
					obj.put(headers[i], values[i]);
				}
				jsonArray.add(obj);
			}
			String jsonOutput = mapper.writeValueAsString(jsonArray);
			System.out.println(jsonOutput);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}