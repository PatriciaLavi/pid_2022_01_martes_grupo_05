package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
		return ResponseEntity.ok(service.listarMascota());
	}
}
