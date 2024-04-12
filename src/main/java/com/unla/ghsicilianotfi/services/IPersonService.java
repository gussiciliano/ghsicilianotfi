package com.unla.ghsicilianotfi.services;
import java.util.List;
import java.util.Optional;

import com.unla.ghsicilianotfi.entities.Person;
import com.unla.ghsicilianotfi.dtos.PersonDTO;


public interface IPersonService {

	public List<Person> getAll();

	public PersonDTO findById(int id);

	public PersonDTO findByName(String name);

	public PersonDTO insertOrUpdate(Person person);

	public boolean remove(int id);

	public List<PersonDTO> findByDegreeName(String degreeName);
}

