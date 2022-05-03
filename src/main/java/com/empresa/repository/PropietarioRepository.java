package com.empresa.repository;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.*;

public interface PropietarioRepository extends JpaRepository<Propietario, Integer>  {
	
}
