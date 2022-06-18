package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Departamento;
import com.empresa.entity.Servicio;
import com.empresa.repository.DepartamentoRepository;


@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	private DepartamentoRepository dptoRepository;

	@Override
	public List<Departamento> listarDptos() {
		
		return dptoRepository.findAll();
	}

	@Override
	public void guardar(Departamento dpto) {
		dptoRepository.save(dpto);
		
	}

	@Override
	public Departamento buscarPorId(Integer id) {		
		return dptoRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		dptoRepository.deleteById(id);
		
	}

	@Override
	public Optional<Departamento> getServicioId(Integer id) {
		return dptoRepository.findById(id);
	}

}
