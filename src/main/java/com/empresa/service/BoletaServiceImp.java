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

	@Override
	public Boleta insertaActualizaBoleta(Boleta obj) {
		return repository.save(obj);
	}

	@Override
	public List<Boleta> getBoletaxServicioPropietarioDepartamento(int idcomboservicio, int idpropietario,
			int iddepartamento) {
		return repository.getBoletaxServicioPropietarioDepartamento(idcomboservicio, idpropietario, iddepartamento);
	}

	@Override
	public Boleta getBoletaxId(Integer id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}

	
}
