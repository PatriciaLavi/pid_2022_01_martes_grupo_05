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
	public List<Visita> ListarVisita() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
