package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Visita;
import com.empresa.repository.VisitaRepository;
@Service
public class VisitaServiceImpl implements VisitaService {

	@Autowired
	private VisitaRepository repository;
	@Override
	public Visita insertaActualizaVistas(Visita obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	@Override
	public List<Visita> listarVisitas() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Visita buscarPorIdvisita(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public Visita ActualizaVistas(Visita obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

	


	

	

}
