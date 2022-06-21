package com.empresa.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.empresa.entity.Propietario;
import com.empresa.entity.Residente;
import com.empresa.repository.PropietarioRepository;

@Service
public class PropietarioServiceImpl implements  PropietarioService {
	@Autowired
	private PropietarioRepository repository;

	@Override
	public List<Propietario> listarPropietarios() {
		return repository.findAll();
	}

	@Override
	public Propietario insertaActualizaPropietario(Propietario obj) {
		return repository.save(obj);
		}


	@Override
	public Propietario buscarPorIdPropietario(Integer id) {
		return repository.findById(id).orElse(null);
		}
	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);
		
		}

	@Override
	public List<Propietario> getPropietario() {
		return repository.findAll();
	}

	@Override
	public Optional<Propietario> getPropiertarioxID(Integer id) {
		return repository.findById(id);
	}	



	
}