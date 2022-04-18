package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Edificio;



public interface EdificioRepository extends JpaRepository<Edificio, Integer> {

}
