package com.empresa.service;

import java.util.List;


import com.empresa.entity.visita;

public interface visitaService {
	
	
	public visita insertaActualizaVistas(visita obj);
	public visita ActualizaVistas(visita obj);
	public List<visita> listarVisitas();
	public visita buscarPorIdvisita(Integer id);
	
	
}
