package com.unla.ghsicilianotfi.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Degree {
	private String name;
	
	@Size(min=3, max=12)
	private String institution;
	
	@Min(3)
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

