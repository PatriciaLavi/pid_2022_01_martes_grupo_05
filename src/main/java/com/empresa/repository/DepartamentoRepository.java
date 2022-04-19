package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.entity.Departamento;



public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
	
public abstract List<Departamento> findBynumDepa(int numDepa);
	
	
	@Query("select e from Departamento e where e.numDepa=:pnumDepa and e.codDepa <>:pcodDepa")
		public abstract List<Departamento> listaDepartamentoPornrohabDiferente(@Param("pnumDepa")int numDep,@Param ("pcodDepa")int codDepa);
		
		
	
}
