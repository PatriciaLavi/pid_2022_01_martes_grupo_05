package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Visitantes;

public interface VisitanteRepository extends JpaRepository<Visitantes, Integer>{

}
