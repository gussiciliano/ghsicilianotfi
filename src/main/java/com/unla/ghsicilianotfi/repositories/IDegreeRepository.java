package com.unla.ghsicilianotfi.repositories;

import java.io.Serializable;
import java.util.List;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.ghsicilianotfi.entities.Degree;

@Repository("degreeRepository")
public interface IDegreeRepository extends JpaRepository<Degree, Serializable> {

	public abstract Optional<Degree> findByName(String name);

	public abstract Optional<Degree> findByInstitutionAndYear(String institution, int year);

	public abstract List<Degree> findByInstitutionAndYearOrderByYearDesc(String institution, int year);
}
