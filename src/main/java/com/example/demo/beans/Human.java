package com.example.demo.beans;

public class Human {

int id;
String name;
String age;
String town;

public Human(int id, String name, String age, String town) {
	super();
	this.id = id;
	this.name = name;
	this.age = age;
	this.town = town;
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

public String getAge() {
	return age;
}

public void setAge(String age) {
	this.age = age;
}

public String getTown() {
	return town;
}

public void setTown(String town) {
	this.town = town;
}






}