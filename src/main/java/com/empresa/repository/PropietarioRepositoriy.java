package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Propietarios;

public interface PropietarioRepositoriy extends JpaRepository<Propietarios, Integer> {

}
