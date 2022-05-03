package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Propietario;
import com.empresa.entity.Residente;

public interface PropietarioService  {
	public List<Propietario> listarPropietarios();
    public abstract Propietario insertaActualizaPropietario(Propietario obj);
	public Propietario buscarPorIdPropietario(Integer id);
	public void eliminar (Integer id);
	

}
