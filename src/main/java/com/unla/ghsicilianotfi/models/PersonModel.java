package com.unla.ghsicilianotfi.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class PersonModel {
	private int id;
	
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthdate;
	
	public PersonModel() {}
	
	public PersonModel(int id, String name, LocalDate birthdate) {
		this.setId(id);
		this.name = name;
		this.birthdate = birthdate;
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

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}
}

