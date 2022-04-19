package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;

import com.empresa.entity.Departamento;



public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {
	
	//cree mi queri  vas a registrar por nro de habitacion el codigo de depa si va a ir obligatoriamente pero para registrar necesito otra variable
	//si te das cuenta de alumno registro a cual de los compas? haber dejame probar 
	
	//@Query("select e from tbdepartamento e where e.=:pnroDepa and e.codDepa <>:pidtbdepartamento")
	//	public abstract List<Departamento> listaDepartamentoPornrohabDiferente(@Param("pnroDepai")int nroDep,@Param ("pidtbdepartamento")int codDepa);
		
		
	
}
