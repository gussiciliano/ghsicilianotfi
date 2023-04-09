package com.unla.ghsicilianotfi.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.unla.ghsicilianotfi.entities.Person;

@Repository("personRepository")
public interface IPersonRepository extends JpaRepository<Person, Serializable> {

	public abstract Person findById(int id);

	public abstract Person findByName(String name);

	// Todas las personas que tengan un título con ese nombre (parámetro name)
	@Query("SELECT p FROM Person p JOIN FETCH p.degrees d WHERE d.name = (:name)")
	public abstract List<Person> findByDegreeName(String name);
}
