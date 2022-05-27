package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Visita;

public interface VisitaRepository extends JpaRepository<Visita, Integer>{

//public abstract List<visita> findByDni(String dni);
	
	
	
}
