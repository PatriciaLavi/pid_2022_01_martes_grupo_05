package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Incidencias;

public interface IncidenciasRepository extends JpaRepository<Incidencias, Integer> {
	
	
	@Query("select x from Incidencias x where  (?1 is -1 or x.iddepartamento=?1)")
	public List<Incidencias>buscarPorDep(int iddepartamento);

}
