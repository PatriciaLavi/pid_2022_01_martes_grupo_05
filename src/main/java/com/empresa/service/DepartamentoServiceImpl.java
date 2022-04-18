package com.empresa.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Departamento;
import com.empresa.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	@Autowired
	private DepartamentoRepository repository; 
	@Override
	public List<Departamento> listarDepartamentos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Override
	public Departamento insertaDepartamento(Departamento obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

}
