package com.unla.ghsicilianotfi.services;
import java.util.List;
import java.util.Optional;

import com.unla.ghsicilianotfi.entities.Person;
import com.unla.ghsicilianotfi.dtos.PersonDTO;

public interface IPersonService {

	List<Person> getAll();

	Optional<Person> findById(int id);

	Person findByName(String name);

	Person insertOrUpdate(Person person);

	boolean remove(int id);

	List<PersonDTO> findByDegreeName(String degreeName);
}

