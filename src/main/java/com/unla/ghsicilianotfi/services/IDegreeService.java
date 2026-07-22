package com.unla.ghsicilianotfi.services;
import java.util.List;

import com.unla.ghsicilianotfi.entities.Degree;
import com.unla.ghsicilianotfi.dtos.DegreeDTO;


@SuppressWarnings("unused")
public interface IDegreeService {

	List<Degree> getAll();

	void insertOrUpdate(DegreeDTO degreeDTO);

	boolean remove(int id);
}

