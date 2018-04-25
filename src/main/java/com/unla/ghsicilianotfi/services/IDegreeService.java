package com.unla.ghsicilianotfi.services;
import java.util.List;

import com.unla.ghsicilianotfi.entities.Degree;


public interface IDegreeService {

	public List<Degree> getAll();
	
	public Degree add(Degree degree);
	
	public Degree insertOrUpdate(Degree degree);
	
	public boolean remove(int id);
}
