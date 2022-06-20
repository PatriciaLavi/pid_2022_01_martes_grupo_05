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
@Table(name = "boleta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Boleta {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idboleta;
	
	@ManyToOne
	@JoinColumn(name = "idcomboservicio")
	private ComboServicio idcomboservicio;
	
	
	@ManyToOne
	@JoinColumn(name = "idpropietario")
	private Propietario idpropietario;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaEmision;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaVenc;
	
	private String estado;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechapago;
}
