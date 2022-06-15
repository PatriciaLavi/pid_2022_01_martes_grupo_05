package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresa.service.BoletaService;
import com.empresa.service.PropietarioService;
import com.empresa.service.ServicioService;

import lombok.extern.apachecommons.CommonsLog;

@Controller
@RequestMapping("/views/boleta")

public class BoletaController {
	@Autowired
	private BoletaService boletaService;
	@Autowired
	private ServicioService servicioService;
	@Autowired
	private PropietarioService propietarioService;
	
	@GetMapping("/")
		public String ListarBoleta(Model model) {
		return null;
	}
}
