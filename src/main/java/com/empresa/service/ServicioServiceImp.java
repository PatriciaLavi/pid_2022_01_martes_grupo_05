package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.empresa.entity.Servicio;
import com.empresa.repository.ServicioRepository;


@Service
public class ServicioServiceImp implements ServicioService{
	@Autowired
	private ServicioRepository ServicioDao;

	@Override
	public List<Servicio> getAllServicio() {
		return ServicioDao.findAll();
	}

	@Override
	public Servicio insertaActualizaServicio(Servicio obj) {
		return ServicioDao.save(obj);
	}
}
