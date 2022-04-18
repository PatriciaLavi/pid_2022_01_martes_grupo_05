package com.empresa.service;

import java.util.List;

import com.empresa.entity.Departamento;


public interface DepartamentoService {
	
	public abstract List<Departamento> listarDepartamentos();
	
	public abstract Departamento insertaDepartamento(Departamento obj);
}
