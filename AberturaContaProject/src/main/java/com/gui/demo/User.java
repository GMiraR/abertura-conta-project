package com.gui.demo;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/*
 * 
 * Gerando automaticamente a tabela users no banco de dados.
 */

@Entity
@Table(name = "users")
public class User {
	
	@Id
	private String cpf;
	
	@Column(nullable = false, length = 64)
	private String password;
	
	@Column(nullable = false, length = 20, columnDefinition="text")
	private String firstName;
	
	@Column(nullable = false, length = 20, columnDefinition="text")
	private String lastName;
	
	@Column(nullable = false, unique = true, length = 45)
	private String email;	
	
	@Column(nullable = false, length = 10)
	private Date birthdate;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	
}
