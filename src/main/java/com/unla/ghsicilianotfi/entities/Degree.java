package com.unla.ghsicilianotfi.entities;

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="degree")
public class Degree {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;
	
	@Column(name="year")
	private double year;
	
	@Column(name="hours")
	private int hours;
	
	@Column(name="createdat")
	@CreationTimestamp
	private GregorianCalendar createdAt;
	
	@Column(name="updatedat")
	@UpdateTimestamp
	private GregorianCalendar updatedAt;

	public Degree() {}
	
	public Degree(int id, String name, String description, double year, int hours, GregorianCalendar createdAt, GregorianCalendar updatedAt) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.year = year;
		this.hours = hours;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getYear() {
		return year;
	}

	public void setYear(double year) {
		this.year = year;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public GregorianCalendar getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(GregorianCalendar createdAt) {
		this.createdAt = createdAt;
	}

	public GregorianCalendar getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(GregorianCalendar updatedAt) {
		this.updatedAt = updatedAt;
	}
}