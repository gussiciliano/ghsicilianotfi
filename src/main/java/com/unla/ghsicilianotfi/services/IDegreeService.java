package com.unla.ghsicilianotfi.services;
import java.util.List;

import com.unla.ghsicilianotfi.entities.Degree;
import com.unla.ghsicilianotfi.models.DegreeModel;


public interface IDegreeService {

	public List<Degree> getAll();

	public DegreeModel insertOrUpdate(DegreeModel degreeModel);

	public boolean remove(int id);
}

