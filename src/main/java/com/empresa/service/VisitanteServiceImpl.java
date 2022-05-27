package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Visitante;
import com.empresa.repository.VisitanteRepository;

@Service
public class VisitanteServiceImpl implements VisitanteService {

	@Autowired
	private VisitanteRepository repositorio;

	@Override
	public Visitante insertaActualizaVistante(Visitante obj) {
		// TODO Auto-generated method stub
		return repositorio.save(obj);
	}

	@Override
	public List<Visitante> listarVisitante() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Visitante buscarPorId(int id) {
		// TODO Auto-generated method stub
		return repositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(int id) {
		 repositorio.deleteById(id);
		
	}

	@Override
	public List<Visitante> listaVisitantePorNombreDni(String nombre, String apellidos, String Dni) {
		// TODO Auto-generated method stub
		return repositorio.listaVisitantePorNombreDni(nombre, apellidos, Dni);
	}
	

}
