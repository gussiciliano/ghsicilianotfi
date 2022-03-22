package com.unla.ghsicilianotfi.services;
import java.util.List;

import com.unla.ghsicilianotfi.entities.Person;
import com.unla.ghsicilianotfi.models.PersonModel;


public interface IPersonService {

	public List<Person> getAll();
	
	public Person findById(int id);
	
	public PersonModel findByName(String name);
	
	public PersonModel insertOrUpdate(Person person);
	
	public boolean remove(int id);
	
	public List<PersonModel> findByDegreeName(String degreeName);
}

