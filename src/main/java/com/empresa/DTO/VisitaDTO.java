package com.empresa.DTO;

import lombok.*;
@Getter
@Setter
public class VisitaDTO {
	private int idvisita;
	private String idvisitante;
	private String dni;
	private String idresidente;
	private String frmFechaHoraEntrada;
	private String frmFechaHoraSalida;
	private String comentario;
	private Boolean estado;
	
}
