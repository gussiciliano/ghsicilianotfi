package com.unla.ghsicilianotfi.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PersonModel {
	private int id;

	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthdate;

	public PersonModel(int id, String name, LocalDate birthdate) {
		this.setId(id);
		this.name = name;
		this.birthdate = birthdate;
	}
}

