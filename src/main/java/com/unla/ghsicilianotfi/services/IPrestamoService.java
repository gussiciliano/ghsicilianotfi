package com.unla.ghsicilianotfi.services;

import java.util.List;

import com.unla.ghsicilianotfi.entities.Prestamo;
import com.unla.ghsicilianotfi.models.PrestamoModel;

public interface IPrestamoService {

	public List<Prestamo> getAll();

	public Prestamo findById(int id);

	public PrestamoModel findByName(int nroPrestamo);

	public Prestamo insertOrUpdate(Prestamo prestamo);
}
