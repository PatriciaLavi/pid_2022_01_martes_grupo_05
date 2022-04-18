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
@Table(name="tbedificio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Edificio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="codEdificio")
	private int codEdificio;
	private int codAdmin;
	private String direccion; 
	private int numpisos; 
	private String descripcion;

}
