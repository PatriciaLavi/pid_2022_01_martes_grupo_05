package com.empresa.DTO;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class NewBoletaDTO {

	private Integer idcomboservicio;
	private double Precioserv;
	private Integer idpropietario;
	private Integer iddepartamento;
	private Date fechaEmision;
	private String fechaVenc;
	private String estado;
}
