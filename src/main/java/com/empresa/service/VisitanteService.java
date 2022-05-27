package com.empresa.service;

import java.util.List;

import com.empresa.entity.Visitante;

public interface VisitanteService {
	public abstract Visitante insertaActualizaVistante(Visitante obj);
	public abstract List<Visitante> listarVisitante();
	public abstract Visitante buscarPorId(int id);
	public abstract void eliminar (int id);
	public List<Visitante> listaVisitantePorNombreDni(String nombre,String apellidos, String Dni);

}
