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
import com.empresa.entity.Mascota;
import com.empresa.service.MascotaService;

@RestController
@RequestMapping("/rest/mascota")
public class MascotaController {
	@Autowired
	private MascotaService service;
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Mascota>> listarMascotas(){
		List<Mascota> lista = service.listarMascota();
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<HashMap<String, Object>> insertaMascota(@RequestBody Mascota obj){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			Mascota objSalida = service.insertaMascota(obj);
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
