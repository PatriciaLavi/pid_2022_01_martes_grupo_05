package com.empresa.service;

import java.util.List;
import java.util.Optional;

import com.empresa.entity.Residente;
public interface ResidenteService {
	
	public List<Residente> listarResidentes();
    public abstract Residente insertaActualizaResidente(Residente obj);
	public Residente buscarPorIdResidente(Integer id);
	public void eliminar (Integer id);
	
	
	
	
	
}



