package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Boleta;
import com.empresa.repository.BoletaRepository;

@Service
public class BoletaServiceImp implements BoletaService{
	@Autowired
	private BoletaRepository repository;

	@Override
	public List<Boleta> listarBoleta() {
	
		return repository.findAll();
	}
}
