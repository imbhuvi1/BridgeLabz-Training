package com.json.practice;

import java.io.File;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXml {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ObjectMapper jsonMapper = new ObjectMapper();
			XmlMapper xmlMapper = new XmlMapper();
			JsonNode jsonNode = jsonMapper.readTree(new File("src/user.json"));
			String xml = xmlMapper.writeValueAsString(jsonNode);
			System.out.println(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}