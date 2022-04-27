package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Departamento;
import com.empresa.entity.Propietarios;


public interface DepartamentoService {
	
     public abstract List<Departamento> listaDepartamento();	
	 public abstract Departamento insetaDepartamento(Departamento obj);
	 public abstract Optional<Departamento> buscaPorcod(int codDepartamento);
	 public abstract void eliminaPorCod(int codDepartamento);
	 public abstract Departamento actualizaDepartamento(Departamento obj);
	
	
}

