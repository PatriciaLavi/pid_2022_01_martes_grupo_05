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
@Table(name = "tbusuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="codUsu")
	private int codUsu;
	private String nomUsu;
	private String apeUsu;
	private String dniUsu;
	private String telefono;
	private int edad;
	private int genero;
	private int estCivil; 
	private String correo;
	private String contraseña;
}
