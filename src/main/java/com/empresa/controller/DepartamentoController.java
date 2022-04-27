package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Departamento;
import com.empresa.entity.Propietarios;
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
			Departamento objsalida=service.actualizaDepartamento(obj);
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
	
//
	@PutMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> actualizaDepartamento(@RequestBody Departamento obj){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			Optional<Departamento> optional = service.buscaPorcod(obj.getCodDepa());
			if (optional.isEmpty()) {
				salida.put("mensaje", "No existe cod de departamento  : " + obj.getCodDepa());
			}else {
				Departamento objSalida = service.actualizaDepartamento(obj);
				if (objSalida == null) {
					salida.put("mensaje", "Error en actualizar");
				}else {
					salida.put("mensaje", "Se actualizó correctamente");
				}
			}
					
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error en actualizar");
		}
		return ResponseEntity.ok(salida);
	}
	
	@DeleteMapping("/{cod}")
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>>eliminaDepartamento(@PathVariable("cod") int codDepartamento){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		Optional<Departamento>optional=service.buscaPorcod(codDepartamento);
		if(optional.isPresent()) {
			service.eliminaPorCod(codDepartamento);
			salida.put("mensaje", "se elimino correctamente");			
		}else {
			salida.put("mensaje", "No existe el cod:" +codDepartamento);
		}
		return ResponseEntity.ok(salida);
	}

	
	
	
	
	
	
	
	
}
