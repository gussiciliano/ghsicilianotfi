package com.unla.ghsicilianotfi.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED) //See more in https://www.baeldung.com/hibernate-inheritance
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private LocalDate birthdate;

	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
	private Set<Degree> degrees = new HashSet<Degree>();
	
	public Person(int id, String name, LocalDate birthdate) {
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	
	public Person(String name) {
		this.name = name;
	}
}