package com.empresa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Visita;

public interface VisitaRepository extends JpaRepository<Visita, Integer>{

	
public List<Visita> findByDni(String dni);

public boolean existsByDni(String dni);

@Query("Select v from Visita v where v.idvisitante= ?1 and v.estado=true")
List<Visita> listaPorEstado(int id);

}
