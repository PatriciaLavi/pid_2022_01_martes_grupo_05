package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Visita;
import com.empresa.service.VisitaService;

@RestController
@RequestMapping("/rest/visita")
public class VisitaController {
	@Autowired 
	private VisitaService service;
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Visita>> listarVisitas(){
		return ResponseEntity.ok(service.ListarVisita());
	}

}
