package com.unla.ghsicilianotfi.controllers;

import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.ghsicilianotfi.entities.Person;
import com.unla.ghsicilianotfi.helpers.ViewRouteHelper;
import com.unla.ghsicilianotfi.dtos.PersonDTO;
import com.unla.ghsicilianotfi.services.IPersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	private static final String PERSON_ATTR = "person";

	private final IPersonService personService;

	private final ModelMapper modelMapper;

	public PersonController(IPersonService personService, ModelMapper modelMapper) {
		this.personService = personService;
		this.modelMapper = modelMapper;
	}

	@GetMapping("")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_INDEX);
		mAV.addObject("persons", personService.getAll());
		return mAV;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_NEW);
		mAV.addObject(PERSON_ATTR, new PersonDTO());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute(PERSON_ATTR) PersonDTO personDTO) {
		personService.insertOrUpdate(modelMapper.map(personDTO, Person.class));
		return new RedirectView(ViewRouteHelper.PERSON_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		Optional<Person> personOptional = personService.findById(id);
		if (personOptional.isEmpty()) {
			return new ModelAndView(new RedirectView(ViewRouteHelper.PERSON_ROOT));
		}
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_UPDATE);
		PersonDTO personDTO = modelMapper.map(personOptional.get(), PersonDTO.class);
		mAV.addObject(PERSON_ATTR, personDTO);
		return mAV;
	}

	@GetMapping("/partial/{id}")
	public ModelAndView getPartial(@PathVariable("id") int id) {
		Optional<Person> personOptional = personService.findById(id);
		if (personOptional.isEmpty()) {
			return new ModelAndView(new RedirectView(ViewRouteHelper.PERSON_ROOT));
		}
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_PARTIAL_VIEW);
		PersonDTO personDTO = modelMapper.map(personOptional.get(), PersonDTO.class);
		mAV.addObject(PERSON_ATTR, personDTO);
		return mAV;
	}

	@GetMapping("/by_name/{name}")
	public ModelAndView getByName(@PathVariable("name") String name) {
		Person person;
		try {
			person = personService.findByName(name);
		} catch (IllegalArgumentException e) {
			return new ModelAndView(new RedirectView(ViewRouteHelper.PERSON_ROOT));
		}
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_UPDATE);
		PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);
		mAV.addObject(PERSON_ATTR, personDTO);
		return mAV;
	}

	@GetMapping("/by_degree/{degree_name}")
	public ModelAndView getByDegreeName(@PathVariable("degree_name") String degreeName) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_INDEX);
		mAV.addObject("persons", personService.findByDegreeName(degreeName));
		return mAV;
	}

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute(PERSON_ATTR) PersonDTO personDTO) {
		personService.findById(personDTO.getId()).ifPresent(personToUpdate -> {
			personToUpdate.setName(personDTO.getName());
			personService.insertOrUpdate(personToUpdate);
		});
		return new RedirectView(ViewRouteHelper.PERSON_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		personService.remove(id);
		return new RedirectView(ViewRouteHelper.PERSON_ROOT);
	}
}
