package com.unla.ghsicilianotfi.entities;

import javax.persistence.Entity;

@Entity
public class Employee extends Person {

	private String workFile;
	
	public Employee() {
		super();
	}

	public String getWorkFile() {
		return workFile;
	}

	public void setWorkFile(String workFile) {
		this.workFile = workFile;
	}
}
