package com.empresa.service;

import java.util.List;


import com.empresa.entity.Visita;

public interface VisitaService {
	
	
	public Visita insertaActualizaVistas(Visita obj);
	public Visita ActualizaVistas(Visita obj);
	public List<Visita> listarVisitas();
	public Visita buscarPorIdvisita(Integer id);
	public List<Visita>BuscaVisitaporDni(String dni);
	public boolean existsByDni(String dni);
	public List<Visita> ListaPorDni(String dni);
	List<Visita> getVisita();
}
