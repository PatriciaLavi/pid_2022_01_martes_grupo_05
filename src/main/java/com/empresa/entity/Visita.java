package com.empresa.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table (name="visita")
@Getter
@Setter
@ToString 
public class Visita implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idvisita;
	private int idvisitante;
	@Column(unique = true)
	private String dni;
	private int idresidente;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechahoraentrada;
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	private Date fechahorasalida;
	private String comentario;
	@Transient
	private String frmFechaHoraEntrada;
	@Transient
	private String frmFechaHoraSalida;
	public String getFrmFechaHoraEntrada() {
		if(fechahoraentrada==null) {
			frmFechaHoraEntrada = "-";
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			frmFechaHoraEntrada = sdf.format(fechahoraentrada);
		}
		return frmFechaHoraEntrada;
	}
	public void setFrmFechaHoraEntrada(String frmFechaHoraEntrada) {
		this.frmFechaHoraEntrada = frmFechaHoraEntrada;
	}
	public String getFrmFechaHoraSalida() {
		if(fechahorasalida==null) {
			frmFechaHoraSalida = "-";
		}else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
			frmFechaHoraSalida = sdf.format(fechahorasalida);
		}
		
		return frmFechaHoraSalida;
	}
	public void setFrmFechaHoraSalida(String frmFechaHoraSalida) {
		this.frmFechaHoraSalida = frmFechaHoraSalida;
	}
	
}
