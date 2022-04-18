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
@Table(name="tbvisita")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Visita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column  (name="codVisita")
	private int codVisita;
	private int codVisitante;
	private Date fechaLlegada; 
	private Date fechaSalida; 
	private Date fechaRegistro;
}
