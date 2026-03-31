package com.json.practice;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Student {
	private String name;
	private int age;
	private String subjects[];

	public Student(String name, int age, String subjects[]) {
		this.name = name;
		this.age = age;
		this.subjects = subjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String[] getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects[]) {
		this.subjects = subjects;
	}
}

public class StudentJson {

	public static void main(String[] args) throws JsonProcessingException {
		// TODO Auto-generated method stub
		String subjects[] = { "CS", "Physics", "Chemistry" };
		Student student = new Student("Govind", 23, subjects);
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(student);
		System.out.println(json);
	}

}
