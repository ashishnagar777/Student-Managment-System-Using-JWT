package com.Student.main.entities;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	@NotBlank(message = "First name is required")
	@Column(name = "first_Name")
	private String firstName;

	@NotBlank(message = "Last name is required")
	@Column(name = "last_Name")
	private String lastName;

	@Email(message = "Invalid email format")
	@Column(unique = true)

	private String email;
	

}
