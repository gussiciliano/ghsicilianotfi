package com.unla.ghsicilianotfi.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DegreeModel {
	private int id;
	
	private String name;
	
	@Size(min=3, max=12)
	private String institution;
	
	@Min(3)
	private int year;
	
	public DegreeModel(int id, String name, String institution, int year) {
		this.setId(id);
		this.name = name;
		this.institution = institution;
		this.year = year;
	}
}

