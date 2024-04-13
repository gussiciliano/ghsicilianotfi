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
	public PersonDTO insertOrUpdate(Person person) {
		Person personNew = personRepository.save(person);
		return modelMapper.map(personNew, PersonDTO.class);
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
	public PersonDTO findById(int id) {
		Person p = personRepository.findById(id).orElse(null);
		return modelMapper.map(p, PersonDTO.class);
	}

	@Override
	public PersonDTO findByName(String name) {
		Person p = personRepository.findByName(name).orElse(null);
		return modelMapper.map(p, PersonDTO.class);
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
