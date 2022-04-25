package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		List<Departamento> lista = service.listaDepartamento();
		return ResponseEntity.ok(lista);
	}
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> insertaDepartamento(@RequestBody Departamento obj){
		HashMap<String, Object> salida = new HashMap<>();
		try {
			obj.setCodDepa(0);
			Departamento objsalida=service.insertaDepartamento(obj);
			if(objsalida == null) {
				salida.put("MENSAJE", "Error al insertar");
			}else{
				salida.put("MENSAJE", "Registro correctamente");
		
		
		}}
			catch (Exception e) {
				e.printStackTrace();
			salida.put("MENSAJE", "No se registro correctamente");
		} 
		
		return ResponseEntity.ok(salida);
	}
	

	
	
}
