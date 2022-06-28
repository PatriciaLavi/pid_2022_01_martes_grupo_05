package com.empresa.DTO;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class IncidenciaDTO {


	private int idincidencia;
	
	
	private int iddepartamento;
	private String tipo;
	private String estado;
	private String  causa;
	private String  descripcion;
}
