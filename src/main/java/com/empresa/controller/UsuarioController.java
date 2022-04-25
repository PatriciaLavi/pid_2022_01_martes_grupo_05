package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Usuario;
import com.empresa.service.UsuarioService;



@RestController
@RequestMapping("/rest/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService service;
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Usuario>> listarAdmins(){
		return ResponseEntity.ok(service.ListarAdmin());
	}

}
