package com.unla.ghsicilianotfi.services;
import java.util.List;
import java.util.Optional;

import com.unla.ghsicilianotfi.entities.Person;
import com.unla.ghsicilianotfi.dtos.PersonDTO;

public interface IPersonService {

	public List<Person> getAll();

	public Optional<Person> findById(int id) throws Exception;

	public Person findByName(String name) throws Exception;

	public Person insertOrUpdate(Person person);

	public boolean remove(int id);

	public List<PersonDTO> findByDegreeName(String degreeName);
}

