package com.empresa.service;

import java.util.List;

import com.empresa.entity.Mascota;

public interface MascotaService {
	
	public abstract List<Mascota> listarMascota();
	

	public abstract Mascota insertaMascota(Mascota obj);

}
