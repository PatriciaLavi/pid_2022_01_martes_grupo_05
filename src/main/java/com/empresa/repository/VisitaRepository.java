package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Visita;

public interface VisitaRepository extends JpaRepository<Visita, Integer>{

	
public List<Visita> findByDni(String dni);

public boolean existsByDni(String dni);
	
/*
@Query("select v from Visita where v.dni like ?1")
	public List<Visita>listaPorDni(String dni);
	*/
}
