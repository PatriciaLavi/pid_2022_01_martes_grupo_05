package com.empresa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "insidencia")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Incidencias {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idincidencia;
	private String iddepartamento;
	private String tipo;
	private String estado;
	private String  causa;
	private String  descripcion;

	
	

}
