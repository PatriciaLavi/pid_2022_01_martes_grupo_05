package com.empresa.entity;
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
@Table(name = "Comboservicio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComboServicio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComboservicio;
	private String nombreserv;
	private Double precioserv;

}
