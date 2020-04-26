package com.unla.ghsicilianotfi.converters;

import org.springframework.stereotype.Component;

import com.unla.ghsicilianotfi.entities.Person;
import com.unla.ghsicilianotfi.models.PersonModel;

@Component("personConverter")
public class PersonConverter {

	public PersonModel entityToModel(Person person) {
		return new PersonModel(person.getId(), person.getName());
	}

	public Person modelToEntity(PersonModel personModel) {
		return new Person(personModel.getId(), personModel.getName());
	}
}

