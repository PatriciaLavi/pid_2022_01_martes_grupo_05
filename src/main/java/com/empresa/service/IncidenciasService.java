package com.empresa.service;

import java.util.List;

import com.empresa.entity.Departamento;
import com.empresa.entity.Incidencias;

public interface IncidenciasService {
	
	public List<Incidencias> listarInc();
	public void guardar(Incidencias Inc);
	public Incidencias buscarPorId(Integer id);
	public void eliminar (Integer id);

}
