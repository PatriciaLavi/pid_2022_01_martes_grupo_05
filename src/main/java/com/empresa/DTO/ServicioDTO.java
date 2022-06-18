package com.empresa.DTO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ServicioDTO {
	
	private int idservicio;
	private int iddepartamento;
	private String idcomboservicio;
	private double precioserv;
	private Date fechareg;
	private String estado;
}
