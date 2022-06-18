package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Departamento;

public interface DepartamentoService {
	
	public List<Departamento> listarDptos();
	public void guardar(Departamento dpto);
	public Departamento buscarPorId(Integer id);
	public void eliminar (Integer id);
	Optional<Departamento> getServicioId(Integer id);

}
