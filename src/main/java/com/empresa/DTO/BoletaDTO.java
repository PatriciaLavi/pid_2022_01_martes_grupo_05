package com.empresa.DTO;


import java.util.Date;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoletaDTO {

	
	private Integer idboleta;
	private String idcomboservicio;
	private double Precioserv;
	private String idpropietario;
	private Integer iddepartamento;
	private Date fechaEmision;
	private String fechaVenc;
	private String estado;
	private Date fechapago;
}