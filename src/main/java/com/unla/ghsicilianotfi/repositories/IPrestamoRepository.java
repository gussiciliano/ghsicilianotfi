package com.unla.ghsicilianotfi.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.ghsicilianotfi.entities.Prestamo;

@Repository("prestamoRepository")
public interface IPrestamoRepository extends JpaRepository<Prestamo, Serializable> {
	
	public abstract Prestamo findById(int id);

	public abstract Prestamo findByNroPrestamo(int nroPrestamo);
}
