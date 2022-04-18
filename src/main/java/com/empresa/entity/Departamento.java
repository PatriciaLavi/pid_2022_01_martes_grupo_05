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
@Table(name="tbDepartamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column  (name="codDepa")
	private int codDepa;
	private int codTipoDepa;
	private int piso;
	private int numHabit;
	private int numDepa;
	private int metros;
	

}
