package com.empresa.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Departamento;
import com.empresa.service.DepartamentoService;


@Controller
@RequestMapping("/rest/departamento")
public class DepartamentoController {
	@Autowired
	private DepartamentoService service;
	@GetMapping
	public ResponseEntity<List<Departamento>> listaDepartamento(){
		List<Departamento> lista = service.listarDepartamentos();
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Departamento> insertaDepartamento(@RequestBody Departamento obj){
		Departamento objsalida = service.insertaDepartamento(obj);
		return ResponseEntity.ok(objsalida);
	}
		
	
	
}
