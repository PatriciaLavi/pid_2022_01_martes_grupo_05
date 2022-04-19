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
		List<Departamento> lista = service.listarDepartamentos();
		return ResponseEntity.ok(lista);
	}
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> insertaDepartamento(@RequestBody Departamento obj){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			List<Departamento> lstDepartamento = service.listadepartamentopornum(obj.getNumDepa());
			if(CollectionUtils.isEmpty(lstDepartamento)) {
				obj.setCodDepa(0);
				Departamento objsalida=service.insertActulizaDepartamento(obj);		
			if(objsalida==null) {
				salida.put("MENSAJE", "Error al insertar");
			}else{
				salida.put("MENSAJE", "Registro correcto");
		}
		}else {
			salida.put("mensaje", "el nro" + obj.getNumDepa() + "ya existe");
		}
		}
			catch (Exception e) {
			salida.put("MENSAJE", "Error al insertar");
		} 
		
		return ResponseEntity.ok(salida);
	}
	

	@PutMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> actualizaDepartamento(@RequestBody Departamento obj){
		HashMap<String, Object> salida=new HashMap<String, Object>();
		try {
			Optional<Departamento> optional= service.buscaPorCod(obj.getCodDepa());
	        if(optional.isEmpty()) {
		salida.put("mensaje", "No existe Departamento de COD:" + obj.getCodDepa());
		
		}else {
			List<Departamento> lstDepartamento=service.listaDepartamentoporCodigodiferentealm(obj.getNumDepa(), obj.getCodDepa());
			if(CollectionUtils.isEmpty(lstDepartamento)) {
				Departamento objsalida=service.insertActulizaDepartamento(obj);
				if(objsalida==null) {
					
					salida.put("mensaje", "error al actualizar");				
				}else {
					salida.put("mensaje", "Se actualizo correctamente");
				}}else {
			salida.put("mensaje", "El Nro de Departamento"+ obj.getNumDepa() +" ya existe.");
		}
	}			
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "error en actualizar");
		}
	
	return ResponseEntity.ok(salida);
	
	
	
}

	
	
}
