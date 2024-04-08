package com.unla.ghsicilianotfi.services;
import java.util.List;

import com.unla.ghsicilianotfi.entities.Degree;
import com.unla.ghsicilianotfi.models.DegreeDTO;


public interface IDegreeService {

	public List<Degree> getAll();

	public DegreeDTO insertOrUpdate(DegreeDTO degreeModel);

	public boolean remove(int id);
}

