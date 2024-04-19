package com.unla.ghsicilianotfi.controllers.api.v1;

import com.unla.ghsicilianotfi.dtos.PersonDTO;
import com.unla.ghsicilianotfi.dtos.RequestPersonDTO;
import com.unla.ghsicilianotfi.entities.Person;
import com.unla.ghsicilianotfi.services.IPersonService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonRestController {

    private IPersonService personService;

    private ModelMapper modelMapper = new ModelMapper();

    public PersonRestController(IPersonService personService){
        this.personService = personService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonDTO>> getPersons(){
        return new ResponseEntity<>(
                personService.getAll().stream()
                        .map(person -> modelMapper.map(person, PersonDTO.class))
                        .collect(Collectors.toList())
                ,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable(name = "id") int id)
            throws Exception {
        return new ResponseEntity<>(
                modelMapper.map(personService.findById(id), PersonDTO.class)
                ,HttpStatus.OK);
    }

    @GetMapping(value = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDTO> getPersonByName(@RequestParam(value = "name") String name)
            throws Exception {
        return new ResponseEntity<>(
                modelMapper.map(personService.findByName(name), PersonDTO.class)
                ,HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDTO> postPerson(@RequestBody RequestPersonDTO requestPersonDTO){
        return new ResponseEntity<>(
                modelMapper.map(personService.insertOrUpdate(
                        modelMapper.map(requestPersonDTO, Person.class)
                ),PersonDTO.class)
                , HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonDTO> putPerson(@RequestBody PersonDTO personDTO) throws Exception {
        Person person = personService.findById(personDTO.getId());
        person.setName(personDTO.getName());
        person.setBirthdate(personDTO.getBirthdate());
        return new ResponseEntity<>(
                modelMapper.map(personService.insertOrUpdate(person),PersonDTO.class)
                , HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePersonById(@PathVariable(name = "id") int id)
            throws Exception {
        return new ResponseEntity<>(
                "Deleted Person with Id " + id + " : " + personService.remove(id)
                ,HttpStatus.OK);
    }

    @GetMapping( value = "/degrees",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonDTO>> getPersonsByDegreeName(@RequestParam(value = "degree") String degree){
        return new ResponseEntity<>(
                personService.findByDegreeName(degree)
                ,HttpStatus.OK);
    }
}
