package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Incidencias;
import com.empresa.repository.IncidenciasRepository;


@Service
public class IncidenciasServiceImpl implements IncidenciasService {
	
	@Autowired
	private IncidenciasRepository incRepository;

	@Override
	public List<Incidencias> listarInc() {
		
		return incRepository.findAll();
	}

	@Override
	public void guardar(Incidencias inc) {
		incRepository.save(inc);
		
	}

	@Override
	public Incidencias buscarPorId(Integer id) {		
		return incRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Integer id) {
		incRepository.deleteById(id);
		
	}

}
