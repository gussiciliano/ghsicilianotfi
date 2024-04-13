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

	private IPersonService personService;

	private ModelMapper modelMapper = new ModelMapper();

	public PersonController(IPersonService personService) {
		this.personService = personService;
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
		mAV.addObject("person", new PersonDTO());
		return mAV;
	}

	@PostMapping("/create")
	public RedirectView create(@ModelAttribute("person") PersonDTO personDTO) {
		personService.insertOrUpdate(modelMapper.map(personDTO, Person.class));
		return new RedirectView(ViewRouteHelper.PERSON_ROOT);
	}

	@GetMapping("/{id}")
	public ModelAndView get(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_UPDATE);
		mAV.addObject("person", personService.findById(id));
		return mAV;
	}

	@GetMapping("/partial/{id}")
	public ModelAndView getPartial(@PathVariable("id") int id) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_PARTIAL_VIEW);
		mAV.addObject("person", personService.findById(id));
		return mAV;
	}

	@GetMapping("/by_name/{name}")
	public ModelAndView getByName(@PathVariable("name") String name) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_UPDATE);
		mAV.addObject("person", personService.findByName(name));
		return mAV;
	}

	@GetMapping("/by_degree/{degree_name}")
	public ModelAndView getByDegreeName(@PathVariable("degree_name") String degreeName) {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.PERSON_INDEX);
		mAV.addObject("persons", personService.findByDegreeName(degreeName));
		return mAV;
	}

	@PostMapping("/update")
	public RedirectView update(@ModelAttribute("person") PersonDTO personDTO) {
		Person person = modelMapper.map(personDTO, Person.class);
		Person personOld = modelMapper.map(personService.findById(personDTO.getId()), Person.class);
		if(personOld != null ) {
			person.setBirthdate(personOld.getBirthdate());
			person.setCreatedAt(personOld.getCreatedAt());
		}
		personService.insertOrUpdate(person);
		return new RedirectView(ViewRouteHelper.PERSON_ROOT);
	}

	@PostMapping("/delete/{id}")
	public RedirectView delete(@PathVariable("id") int id) {
		personService.remove(id);
		return new RedirectView(ViewRouteHelper.PERSON_ROOT);
	}
}
