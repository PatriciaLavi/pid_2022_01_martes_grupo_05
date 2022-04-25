package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Departamento;


public interface DepartamentoService {
	
public abstract List<Departamento> listaDepartamento();
	
	
	public Departamento insertaDepartamento(Departamento obj);
}

