package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Departamento;
import com.empresa.entity.Propietarios;
import com.empresa.repository.DepartamentoRepository;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	@Autowired
	private DepartamentoRepository repository;

	



	




	@Override
	public List<Departamento> listaDepartamento() {
		
		return repository.findAll();
	}
 
	@Override
	public Optional<Departamento> buscaPorcod(int codDepartamento) {
		
		return repository.findById(codDepartamento);
	}

	@Override
	public void eliminaPorCod(int codDepartamento) {
		repository.deleteById(codDepartamento);
		
	}




	@Override
	public Departamento insetaDepartamento(Departamento obj) {
		
		return repository.save(obj);
	}





	@Override
	public Departamento actualizaDepartamento(Departamento obj) {
		
		return repository.save(obj);
	}


























	


}
