package com.unla.ghsicilianotfi.entities;

import javax.persistence.Entity;

@Entity
public class Client extends Person {

	private String mail;
	
	public Client() {
		super();
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}
