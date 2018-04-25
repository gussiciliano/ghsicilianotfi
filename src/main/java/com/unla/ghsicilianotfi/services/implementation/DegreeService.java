package com.unla.ghsicilianotfi.services.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.ghsicilianotfi.entities.Degree;
import com.unla.ghsicilianotfi.repositories.IDegreeRepository;
import com.unla.ghsicilianotfi.services.IDegreeService;


@Service("degreeService")
public class DegreeService implements IDegreeService {

	@Autowired
	@Qualifier("degreeRepository")
	private IDegreeRepository degreeRepository;
	
	@Override
	public List<Degree> getAll() {
		return degreeRepository.findAll();
	}
	
	@Override
	public Degree add(Degree degree) {
		return degreeRepository.save(degree);
	}

	@Override
	public Degree insertOrUpdate(Degree degree) {
		return degreeRepository.save(degree);
	}

	@Override
	public boolean remove(int id) {
		try {
			degreeRepository.delete(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}