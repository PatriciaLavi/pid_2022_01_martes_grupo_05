package com.empresa.service;

import java.util.List;


import com.empresa.entity.Visita;

public interface VisitaService {
	
	
	public Visita insertaActualizaVistas(Visita obj);
	public Visita ActualizaVistas(Visita obj);
	public List<Visita> listarVisitas();
	public Visita buscarPorIdvisita(Integer id);
	
	
}
