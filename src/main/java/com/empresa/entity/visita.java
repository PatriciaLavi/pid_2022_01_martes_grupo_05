package com.empresa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table (name="visita")
@Getter
@Setter
@ToString 
public class visita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvisita;
	private int idvisitante;
	private String dni;
	private int idresidente;

	@DateTimeFormat(pattern = "yyyy-mm-dd hh-mm-ss")
	@Temporal(TemporalType.DATE)
	private Date fechahoraentrada;

	
	@DateTimeFormat(pattern = "yyyy-mm-dd hh-mm-ss")
	@Temporal(TemporalType.DATE)
	private Date fechahorasalida;
	
}
