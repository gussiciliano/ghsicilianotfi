package com.unla.ghsicilianotfi.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Employee extends Person {

	private String workFile;
}
