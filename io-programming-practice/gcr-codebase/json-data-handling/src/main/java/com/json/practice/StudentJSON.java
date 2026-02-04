package com.json.practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class StudentJSON {
	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			
			ObjectNode student = mapper.createObjectNode();
			
			student.put("name","Bhuvnesh Singh Bhadauriya");
			student.put("age", 21);
			
			ArrayNode students = mapper.createArrayNode();
			students.add("Java"); students.add("Full Stack"); students.add("AI");
			
			student.set("subjects", students);
			
			String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
			
			System.out.println(json);
		}catch(JsonProcessingException e) {
			System.out.println("Error arised"+e.getMessage());
		}
		
	}
}
