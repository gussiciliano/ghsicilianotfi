package com.unla.ghsicilianotfi.services;
import java.util.List;

import com.unla.ghsicilianotfi.entities.Person;
import com.unla.ghsicilianotfi.models.PersonModel;


public interface IPersonService {

	public List<Person> getAll();
	
	public PersonModel findById(int id);
	
	public PersonModel findByName(String name);
	
	public PersonModel insertOrUpdate(PersonModel personModel);
	
	public boolean remove(int id);
}

