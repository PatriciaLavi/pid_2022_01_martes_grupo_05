package com.empresa.service;

import java.util.List;

import com.empresa.entity.Mascota;
import com.empresa.entity.Propietario;


public interface MascotaService {
	public List<Mascota> listarMascota();
    public abstract Mascota insertaActualizaMascota(Mascota obj);
	public Mascota buscarPorIdMascota(Integer id);
	public void eliminar (Integer id);
	
	

}



