package com.empresa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empresa.entity.Propietarios;
import com.empresa.repository.PropietarioRepositoriy;
@Service

public class PropietarioServiceImpl implements PropietarioService {

	@Autowired
	private PropietarioRepositoriy repository;
		@Override
	public List<Propietarios> ListarPropietario() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
		@Override
		public Propietarios insertaPropietario(Propietarios obj) {
			// TODO Auto-generated method stub
			return repository.save(obj);
		}

}
