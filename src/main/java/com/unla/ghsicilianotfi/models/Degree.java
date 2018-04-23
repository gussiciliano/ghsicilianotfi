package com.unla.ghsicilianotfi.models;

public class Degree {
	private String name;
	private String institution;
	private String year;
	
	public Degree() {}
	
	public Degree(String name, String institution, String year) {
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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}

