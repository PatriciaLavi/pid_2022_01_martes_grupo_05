package com.empresa.DTO;

import lombok.*;

@Getter
@Setter
public class VisitanteDTO {
	private Integer idvisitante;
	private String nombre;
	private String apellidos;
	private String dni;
	private String correo;
	private String telefono;
	private String activo;
}
