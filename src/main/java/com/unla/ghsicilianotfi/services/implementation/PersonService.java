package com.unla.ghsicilianotfi.services.implementation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unla.ghsicilianotfi.entities.Person;
import com.unla.ghsicilianotfi.models.PersonModel;
import com.unla.ghsicilianotfi.repositories.IPersonRepository;
import com.unla.ghsicilianotfi.services.IPersonService;


@Service("personService")
public class PersonService implements IPersonService {

	private IPersonRepository personRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public PersonService(IPersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	@Override
	public PersonModel insertOrUpdate(Person person) {
		Person personNew = personRepository.save(person);
		return modelMapper.map(personNew, PersonModel.class);
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
	public Optional<Person> findById(int id) {
		return personRepository.findById(id);
	}

	@Override
	public PersonModel findByName(String name) {
		return modelMapper.map(personRepository.findByName(name), PersonModel.class);
	}

	@Override
	public List<PersonModel> findByDegreeName(String degreeName) {
		List<PersonModel> models = new ArrayList<>();
		for (Person person : personRepository.findByDegreeName(degreeName)) {
			models.add(modelMapper.map(person, PersonModel.class));
		}
		return models;
	}
}
