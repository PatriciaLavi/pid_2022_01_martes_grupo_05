package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.ComboServicio;


public interface ComboServicioService{
	List<ComboServicio> getAllComboServicio();
	Optional<ComboServicio> getIdComboServicio(Integer id);
	Optional<ComboServicio> buscarPrecioxId(Integer id);
}
