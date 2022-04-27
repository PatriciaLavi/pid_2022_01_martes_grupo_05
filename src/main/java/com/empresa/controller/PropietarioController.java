package com.empresa.controller;

import java.util.Date;
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
import com.empresa.service.PropietarioService;

@RestController
@RequestMapping("/rest/propietario")
public class PropietarioController {
	@Autowired
	private PropietarioService service;
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Propietarios>> listarPropietarios(){
		List<Propietarios> lista = service.ListarPropietario();
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> insertaPropietario(@RequestBody Propietarios obj){
		HashMap<String, Object> salida = new HashMap<>();
		try {
			
			
			obj.setFechaNacimiento(new Date());
			obj.setGenero(0);
			obj.setEstCivil(1);;
			
			Propietarios objSalida = service.insertaPropietario(obj);
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


	
	