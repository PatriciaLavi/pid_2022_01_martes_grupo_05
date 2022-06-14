package com.empresa.DTO;

import lombok.*;

@Getter
@Setter
public class NewVisitaDTO {
	private Integer idvisitante;
	private String dni;
	private Integer idresidente;
	private String frmFechaHoraEntrada;
	private String frmFechaHoraSalida;
	private  boolean estado;
	
}
