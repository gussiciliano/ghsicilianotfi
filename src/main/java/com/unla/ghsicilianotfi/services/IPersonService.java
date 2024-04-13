package com.unla.ghsicilianotfi.services;
import java.util.List;

import com.unla.ghsicilianotfi.entities.Person;
import com.unla.ghsicilianotfi.dtos.PersonDTO;

public interface IPersonService {

	public List<Person> getAll();

	public Person findById(int id);

	public Person findByName(String name);

	public Person insertOrUpdate(Person person);

	public boolean remove(int id);

	public List<PersonDTO> findByDegreeName(String degreeName);
}

