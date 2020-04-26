package com.unla.ghsicilianotfi.models;

public class PersonModel {
	private int id;
	
	private String name;
	
	public PersonModel() {}
	
	public PersonModel(int id, String name) {
		this.setId(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

