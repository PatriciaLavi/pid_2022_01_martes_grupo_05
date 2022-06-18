package com.empresa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.ComboServicio;

public interface ComboServicioRepository extends JpaRepository<ComboServicio, Integer>{
	@Query("select x.precioserv from ComboServicio x where x.idComboservicio like ?1")
	public Optional<ComboServicio> buscarPrecioxId(Integer id);
}
