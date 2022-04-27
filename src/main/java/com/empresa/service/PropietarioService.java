package com.empresa.service;

import java.util.List;
import java.util.Optional;	

import com.empresa.entity.Propietarios;

public interface PropietarioService {
	public abstract List<Propietarios> ListarPropietario();
	public abstract Propietarios insertaPropietario(Propietarios obj);



	
	
}
