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

		return repository.save(obj);
	}

	@Override
	public List<Visita> listarVisitas() {

		return repository.findAll();
	}

	@Override
	public Visita buscarPorIdvisita(Integer id) {

		return repository.findById(id).orElse(null);
	}

	@Override
	public Visita ActualizaVistas(Visita obj) {

		return repository.save(obj);
	}

	@Override
	public List<Visita> BuscaVisitaporDni(String dni) {

		return repository.findByDni(dni);
	}

	@Override
	public boolean existsByDni(String dni) {
		return repository.existsByDni(dni);
	}

	@Override
	public List<Visita> ListaPorDni(String dni) {
		return repository.findByDni(dni);
	}
	

}
