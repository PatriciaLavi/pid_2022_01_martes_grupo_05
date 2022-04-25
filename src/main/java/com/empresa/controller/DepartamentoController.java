package com.empresa.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Departamento;
import com.empresa.service.DepartamentoService;


@RestController
@RequestMapping("/rest/departamento")
public class DepartamentoController {
	@Autowired
	private DepartamentoService service;
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Departamento>> listaDepartamento(){
		List<Departamento> lista = service.listarDepartamentos();
		return ResponseEntity.ok(lista);
	}//a
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> insertaDepartamento(@RequestBody Departamento obj){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			Departamento objSalida = service.insertaDepartamento(obj);
			if(objSalida==null) {
				salida.put("MENSAJE", "Error al insertar");
			}else{
				salida.put("MENSAJE", "Registro correcto");
		}
		}catch (Exception e) {
			salida.put("MENSAJE", "Error al insertar");
		} 
		
		return ResponseEntity.ok(salida);
	}
	
	
	
	
	
}
