package com.empresa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empresa.entity.Residente;
import com.empresa.repository.ResidenteRepository;


@Service
public class ResidenteServiceImp implements ResidenteService{
	@Autowired
	private ResidenteRepository repository;

	@Override
	public List<Residente> listarResidentes() {
		return repository.findAll();
	}

	@Override
	public Residente insertaActualizaResidente(Residente obj) {
		return repository.save(obj);
	}

	@Override
	public Residente buscarPorIdResidente(Integer id) {
		return repository.findById(id).orElse(null);
	}
	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
		
	}	
	
}
	