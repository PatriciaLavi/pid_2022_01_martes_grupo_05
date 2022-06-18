package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.ComboServicio;
import com.empresa.repository.ComboServicioRepository;

@Service
public class ComboServicioServiceImpl implements ComboServicioService {
	@Autowired
	private ComboServicioRepository ComboServicioDao;
	
	@Override
	public List<ComboServicio> getAllComboServicio() {
		return ComboServicioDao.findAll();
	}
	@Override
	public Optional<ComboServicio> getIdComboServicio(Integer id) {
		return ComboServicioDao.findById(id);
	}
	@Override
	public Optional<ComboServicio> buscarPrecioxId(Integer id) {
		return ComboServicioDao.buscarPrecioxId(id);
	}

}
