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
	private int iduser;
	
	@ManyToOne
	@JoinColumn(name = "idResidente")
	private Residente idresidente;
	
	private String tipo;
	private String  descripcion;
	private String estado;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechareg;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date fechaatencion;
	
		
	

	
	

}
