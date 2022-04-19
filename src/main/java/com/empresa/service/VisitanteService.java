package com.empresa.service;

import java.util.List;

import com.empresa.entity.Visitantes;

public interface VisitanteService {
	public abstract List<Visitantes> ListarVisitante();
	public abstract Visitantes insertaVisitante(Visitantes obj);
}
