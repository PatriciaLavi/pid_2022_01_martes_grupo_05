package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Visitantes;
import com.empresa.repository.VisitanteRepository;

@Service
public class VisitanteServiceImpl implements VisitanteService {

	@Autowired
	private VisitanteRepository repository;
	@Override
	public List<Visitantes> ListarVisitante() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Override
	public Visitantes insertaVisitante(Visitantes obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}
	

}
