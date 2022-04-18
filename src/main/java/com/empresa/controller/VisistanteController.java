package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Visitantes;
import com.empresa.service.VisitanteService;

@RestController
@RequestMapping("/rest/visitante")
public class VisistanteController {

	@Autowired
	private VisitanteService service;
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Visitantes>> listarVisistantes(){
		return ResponseEntity.ok(service.ListarVisitante());
	}
	
}
