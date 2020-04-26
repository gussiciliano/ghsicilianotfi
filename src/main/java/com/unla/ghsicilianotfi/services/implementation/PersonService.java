package com.unla.ghsicilianotfi.services.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.ghsicilianotfi.converters.PersonConverter;
import com.unla.ghsicilianotfi.entities.Person;
import com.unla.ghsicilianotfi.models.PersonModel;
import com.unla.ghsicilianotfi.repositories.IPersonRepository;
import com.unla.ghsicilianotfi.services.IPersonService;


@Service("personService")
public class PersonService implements IPersonService {

	@Autowired
	@Qualifier("personRepository")
	private IPersonRepository personRepository;
	
	@Autowired
	@Qualifier("personConverter")
	private PersonConverter personConverter;
	
	@Override
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	@Override
	public PersonModel insertOrUpdate(PersonModel personModel) {
		Person person = personRepository.save(personConverter.modelToEntity(personModel));
		return personConverter.entityToModel(person);
	}

	@Override
	public boolean remove(int id) {
		try {
			personRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	@Override
	public PersonModel findById(int id) {
		return personConverter.entityToModel(personRepository.findById(id));
	}

	@Override
	public PersonModel findByName(String name) {
		return personConverter.entityToModel(personRepository.findByName(name));
	}
}
