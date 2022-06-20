package com.empresa.DTO;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoletaDTO {

	
	private Integer idboleta;
	private String idcomboservicio;
	private String idpropietario;
	private Date fechaEmision;
	private Date fechaVenc;
	private String estado;
	private Date fechapago;
}
