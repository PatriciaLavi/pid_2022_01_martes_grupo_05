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
@Table(name="tbmascota")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column  (name="codMascota")
	private int codMascota;
	private String nomMascota;
	private String tipoMascota;
	private String descMascota;
	private int codPropietario;
}
