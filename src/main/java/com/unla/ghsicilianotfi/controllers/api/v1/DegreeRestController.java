package com.unla.ghsicilianotfi.contollers.api.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.ghsicilianotfi.models.DegreeDTO;

@RestController
@RequestMapping("/api/v1/degree")
public class DegreeRestController {

	@GetMapping("/all")
	public ResponseEntity<List<DegreeDTO>> allDegrees() {
		List<DegreeDTO> degrees = new ArrayList<>();
		degrees.add(new DegreeDTO(1, "Lic. Sistemas", "UNLa", 2018));
		degrees.add(new DegreeDTO(2, "Lic. Turismo", "UNLa", 2018));
		return new ResponseEntity<>(degrees, HttpStatus.OK);
	}
	
	//AGREGAR CRUD
}
