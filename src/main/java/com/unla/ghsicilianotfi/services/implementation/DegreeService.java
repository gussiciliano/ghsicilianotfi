package com.unla.ghsicilianotfi.services.implementation;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.unla.ghsicilianotfi.entities.Degree;
import com.unla.ghsicilianotfi.dtos.DegreeDTO;
import com.unla.ghsicilianotfi.repositories.IDegreeRepository;
import com.unla.ghsicilianotfi.services.IDegreeService;


@Service("degreeService")
public class DegreeService implements IDegreeService {

	private IDegreeRepository degreeRepository;

	private ModelMapper modelMapper = new ModelMapper();

	public DegreeService(IDegreeRepository degreeRepository) {
		this.degreeRepository = degreeRepository;
	}

	@Override
	public List<Degree> getAll() {
		return degreeRepository.findAll();
	}

	@Override
	public DegreeDTO insertOrUpdate(DegreeDTO degreeModel) {
		Degree degree = degreeRepository.save(modelMapper.map(degreeModel, Degree.class));
		return modelMapper.map(degree, DegreeDTO.class);
	}

	@Override
	public boolean remove(int id) {
		try {
			degreeRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
