package com.unla.ghsicilianotfi.contollers.api.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unla.ghsicilianotfi.models.DegreeModel;

@RestController
@RequestMapping("/api/v1/degree")
public class DegreeRestController {

	@GetMapping("/all")
	public ResponseEntity<List<DegreeModel>> allDegrees() {
		List<DegreeModel> degrees = new ArrayList<DegreeModel>();
		degrees.add(new DegreeModel(1, "Lic. Sistemas", "UNLa", 2018));
		degrees.add(new DegreeModel(2, "Lic. Turismo", "UNLa", 2018));
		return new ResponseEntity<List<DegreeModel>>(degrees, HttpStatus.OK);
	}
}
