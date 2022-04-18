package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Admin;
import com.empresa.service.AdminService;



@RestController
@RequestMapping("/rest/admin")
public class AdminController {
	@Autowired
	private AdminService service;
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Admin>> listarAdmins(){
		return ResponseEntity.ok(service.ListarAdmin());
	}

}
