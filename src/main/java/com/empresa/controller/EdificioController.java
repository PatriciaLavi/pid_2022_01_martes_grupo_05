package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Edificio;
import com.empresa.service.EdificioService;


@RestController
@RequestMapping("/rest/edificio")
public class EdificioController {

	@Autowired
	private EdificioService service;
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Edificio>> listarEdificios(){
		return ResponseEntity.ok(service.listarEdificios());
	}
	
}
