package com.empresa.entity;

import java.util.Date;

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
@Table(name="tbpropietarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Propietarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="codPropietario")
	private int codPropietario; 
	private int codDepa; 
	private String nomPropietario;
	private String apePropietario; 
	private String dniPropietario; 
	private String telefono; 
	private Date fechaNacimiento; 
	private int genero; 
	private int estCivil; 
	private Date fechaArriendo; 
	private String correo; 
	private int CantMascota; 
}
