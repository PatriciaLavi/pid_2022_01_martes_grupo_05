package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.empresa.entity.Boleta;
import com.empresa.entity.Visitante;

public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
	@Query("select x from Boleta x where (?1 is -1 or x.idcomboservicio=?1) and(?2 is -1 or x.idpropietario=?2) and (?3 is -1 or x.iddepartamento=?3)")
	public List<Boleta> getBoletaxServicioPropietarioDepartamento(int idcomboservicio,int  idpropietario, int  iddepartamento);
}
