package com.empresa.DTO;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.empresa.entity.Residente;
import com.empresa.entity.Visitante;
import com.fasterxml.jackson.annotation.JsonFormat;
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
	
}
