package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Visitante;

public interface VisitanteRepository extends JpaRepository<Visitante,Integer>  {
	@Query("select x from Visitante x where (?1 is '' or x.nombre like ?1) and(?2 is '' or x.apellidos like ?2) and (?3 is '' or x.dni like ?3)")
	public List<Visitante> listaVisitantePorNombreDni(String nombre,String apellidos, String Dni);
}
