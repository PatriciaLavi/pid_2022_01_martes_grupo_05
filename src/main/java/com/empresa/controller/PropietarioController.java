package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Propietarios;
import com.empresa.service.PropietarioService;

@RestController
@RequestMapping("/rest/propietario")
public class PropietarioController {
	@Autowired
	private PropietarioService service;
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Propietarios>> listarPropietarios(){
		return ResponseEntity.ok(service.ListarPropietario());
	}
	

}