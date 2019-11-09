package com.java8;

public class Person {
	private int id;
	private String name;
	private String city;
	private int age;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Person(int age, String name, String city) {
		this.age = age;
		this.name = name;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", city=" + city + ", age=" + age + "]";
	}

}
