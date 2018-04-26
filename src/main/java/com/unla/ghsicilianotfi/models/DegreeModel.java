package com.unla.ghsicilianotfi.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class DegreeModel {
	private int id;
	
	private String name;
	
	@Size(min=3, max=12)
	private String institution;
	
	@Min(3)
	private int year;
	
	public DegreeModel() {}
	
	public DegreeModel(int id, String name, String institution, int year) {
		this.setId(id);
		this.name = name;
		this.institution = institution;
		this.year = year;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

