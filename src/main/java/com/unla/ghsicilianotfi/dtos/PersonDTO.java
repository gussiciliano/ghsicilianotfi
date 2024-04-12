package com.unla.ghsicilianotfi.dtos;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class PersonDTO {
	private int id;

	private String name;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthdate;

	public PersonDTO(int id, String name, LocalDate birthdate) {
		this.setId(id);
		this.name = name;
		this.birthdate = birthdate;
	}
}

