package com.empresa.service;

import java.util.List;
import java.util.Optional;

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
		
		return repository.findAll();
	}



	@Override
	public Departamento insertActulizaDepartamento(Departamento obj) {
		
		return repository.save(obj);
	}

	@Override
	public List<Departamento> listadepartamentopornum(int numDep) {
		
		return repository.findBynumDepa(numDep);
	}

	@Override
	public Optional<Departamento> buscaPorCod(int codDepa) {
		
		return repository.findById(codDepa);
	}

	@Override
	public List<Departamento> listaDepartamentoporCodigodiferentealm(int numDep, int codDepa) {
		
		return repository.listaDepartamentoPornrohabDiferente(numDep, codDepa);
	}


}
