package com.empresa.service;

import java.util.List;

import com.empresa.entity.visitante;

public interface visitanteService {
	public abstract visitante insertaActualizaVistante(visitante obj);
	public abstract List<visitante> listarVisitante();
	public abstract visitante buscarPorId(int id);
	public abstract void eliminar (int id);

}
