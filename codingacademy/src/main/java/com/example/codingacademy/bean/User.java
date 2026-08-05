package com.example.codingacademy.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Email Cannot be Blank")
	@Email(message = "Enter a valid email")
	@Column(unique = true)
	private String email;
	
	@NotBlank(message = "Phone number is required")
	@jakarta.validation.constraints.Pattern(
		    regexp = "^[6-9]\\d{9}$",
		    message = "Enter a valid 10-digit mobile number"
		)
	@Column(unique = true)
	private String phone;
	
	
	@NotBlank(message = "Password is required")
	@Size(min = 6, message = "Password must contain atleast 6 characters ")
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String name, String email, String phone, String password, Role role) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.role = role;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	

	

}