package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.tipoDepartamento;
import com.empresa.service.TipoDepartamentoService;


//ee
@RestController
@RequestMapping("/rest/tipoDepartamento")
public class TipoDepartamentoController {

	@Autowired
	private TipoDepartamentoService service;
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<tipoDepartamento>> listarTiposDepartamentos(){
		return ResponseEntity.ok(service.listarTiposDepartamentos());
	}
}
