package com.empresa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbadmin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="codAdmin")
	private int codAdmin;
	private String nomAdmin;
	private String apeAdmin;
	private String dniAdmin;
	private String telefono;
	private int edad;
	private int genero;
	private int estCivil; 
	private String correo;
}
