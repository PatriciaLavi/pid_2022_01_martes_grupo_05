package com.empresa.entity;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "residente")
@Getter
@Setter
public class Residente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idResidente;
	private int iddepartamento;
	private String nombre;
	private String apellidos;
	private String dni;
	private String correo;
	private int telefono;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaNac;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaReg;
	private int estado;
	
	
	
}
