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
@Table(name = "tbvisitantes" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visitantes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column  (name="codVisitante")
	private int codVisitante;
	private int codDepa;
	private int codUsu;
	private String nomVisitante; 
	private String apeVisitante;
	private String dniVisitante; 
	private String telefono; 
	private int  genero; 
	private Date fechaNacimiento;
}
