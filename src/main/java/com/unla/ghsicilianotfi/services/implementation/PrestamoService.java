package com.unla.ghsicilianotfi.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unla.ghsicilianotfi.entities.Prestamo;
import com.unla.ghsicilianotfi.models.PrestamoModel;
import com.unla.ghsicilianotfi.repositories.IPrestamoRepository;
import com.unla.ghsicilianotfi.services.IPrestamoService;

@Service("prestamoService")
public class PrestamoService implements IPrestamoService {

	@Autowired
	@Qualifier("prestamoRepository")
	private IPrestamoRepository prestamoRepository;
	
	@Override
	public List<Prestamo> getAll() {
		return prestamoRepository.findAll();
	}

	@Override
	public Prestamo findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrestamoModel findByName(int nroPrestamo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prestamo insertOrUpdate(Prestamo prestamo) {
		return prestamoRepository.save(prestamo);
	}

}
