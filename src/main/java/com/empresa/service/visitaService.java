package com.empresa.service;

import java.util.List;

import com.empresa.entity.visita;

public interface visitaService {
	public visita insertaActualizaVistas(visita obj);
	public List<visita> listarVisitas();
}
