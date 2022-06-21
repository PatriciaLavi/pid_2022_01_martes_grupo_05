package com.empresa.service;

import java.util.List;

import com.empresa.entity.Boleta;
import com.empresa.entity.Propietario;

public interface BoletaService {

	public List<Boleta> listarBoleta();
	public abstract Boleta insertaActualizaBoleta(Boleta obj);
	public List<Boleta> getBoletaxServicioPropietarioDepartamento(int idcomboservicio,int  idpropietario, int  iddepartamento);
	public Boleta getBoletaxId(Integer id);
}


