package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Departamento;


public interface DepartamentoService {
	
	public abstract List<Departamento> listarDepartamentos();
	public abstract Departamento insertActulizaDepartamento(Departamento obj);
	public abstract List<Departamento>listadepartamentopornum(int numDep);
	public abstract Optional<Departamento>buscaPorCod(int codDepa);
	public abstract List<Departamento>listaDepartamentoporCodigodiferentealm(int numDep,int codDepa);
}

