package com.unla.ghsicilianotfi.services.implementation;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unla.ghsicilianotfi.entities.Person;
import com.unla.ghsicilianotfi.dtos.PersonDTO;
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
	public Person insertOrUpdate(Person person) {
		return personRepository.save(person);
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
	public Person findById(int id) {
		return personRepository.findById(id).orElse(null);
	}

	@Override
	public Person findByName(String name) {
		return personRepository.findByName(name).orElse(null);
	}

	@Override
	public List<PersonDTO> findByDegreeName(String degreeName) {
		List<PersonDTO> models = new ArrayList<>();
		for (Person person : personRepository.findByDegreeName(degreeName)) {
			models.add(modelMapper.map(person, PersonDTO.class));
		}
		return models;
	}
}
