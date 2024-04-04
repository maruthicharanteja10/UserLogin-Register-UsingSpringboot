package com.springboot.project.TejUserApplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "firstname")
	private String firstname;
	@Column(name = "lastname")
	private String lastname;
	@Column(name = "email")
	private String email;
	@Column(name = "phoneno")
	private Long phoneno;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String firstname, String lastname, String email, Long phoneno) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneno = phoneno;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phoneno=" + phoneno + ", getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname()
				+ ", getEmail()=" + getEmail() + ", getPhoneno()=" + getPhoneno() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}

}
