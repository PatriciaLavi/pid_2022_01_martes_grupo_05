package com.empresa.service;

import java.util.List;

import com.empresa.entity.Servicio;

public interface ServicioService {
	List<Servicio> getAllServicio();
	public abstract Servicio insertaActualizaServicio(Servicio obj);
	
}
