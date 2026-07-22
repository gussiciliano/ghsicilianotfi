package com.unla.ghsicilianotfi.controllers.api.v1;

import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.ghsicilianotfi.dtos.DegreeDTO;
import com.unla.ghsicilianotfi.services.IDegreeService;

@RestController
@RequestMapping("/api/v1/degree")
public class DegreeRestController {
	private final IDegreeService degreeService;

	private final ModelMapper modelMapper;

	public DegreeRestController(IDegreeService degreeService, ModelMapper modelMapper) {
		this.degreeService = degreeService;
		this.modelMapper = modelMapper;
	}

	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DegreeDTO>> allDegrees() {
		List<DegreeDTO> degrees = degreeService.getAll().stream()
				.map(degree -> modelMapper.map(degree, DegreeDTO.class))
				.toList();
		return new ResponseEntity<>(degrees, HttpStatus.OK);
	}
}
