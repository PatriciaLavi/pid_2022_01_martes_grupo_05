package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresa.entity.Departamento;
import com.empresa.service.DepartamentoService;


@Controller
@RequestMapping("/rest/departamento")
public class DepartamentoController {
	@Autowired
	private DepartamentoService service;
	@GetMapping
	public ResponseEntity<List<Departamento>> listaDepartamento(){
		return ResponseEntity.ok(service.listarDepartamentos());
	}
	
}
