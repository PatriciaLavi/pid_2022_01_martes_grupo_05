package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Propietarios;
import com.empresa.repository.PropietarioRepositoriy;


@Service

public class PropietarioServiceImpl implements PropietarioService {

	@Autowired
	private PropietarioRepositoriy repository;
	
		@Override
	public List<Propietarios> ListarPropietario() {
		
		return repository.findAll();
	}
		@Override
		public Propietarios insertaPropietario(Propietarios obj) {
			
			return repository.save(obj);
		}
		
}
