package com.empresa.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Residente;
import com.empresa.entity.visita;
import com.empresa.entity.visitante;
import com.empresa.service.visitaService;
import com.empresa.service.visitanteService;


@Controller
@RequestMapping("/views/visita")

public class visitaController {

	@Autowired
	private visitaService service;

	
	@GetMapping("/")
	public String ListarVisita(Model model) {
		List<visita> lista = service.listarVisitas();

		model.addAttribute("titulo", "visitante");
		model.addAttribute("visita", lista);
		return "/views/visita/listar";
	}	

	
	@GetMapping("/registrar")
	public String RegistrarVisitantes(Model model) {

	 visita visita = new visita();
	 model.addAttribute("visita", visita);
		
		return "/views/visita/registrar";
	}	
	@PostMapping("/save")
	public String Guardar(@ModelAttribute visita obj) {
		DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		Date fecha = new Date(dtf4.format(LocalDateTime.now()));
		obj.setFechahoraentrada(fecha);
		obj.setFechahorasalida(null);
		service.insertaActualizaVistas(obj);
		return "redirect:/views/visita/";
	}

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer idvisita ,Model model,@ModelAttribute visita obj) {
		DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		Date fecha = new Date(dtf4.format(LocalDateTime.now()));
		visita visita= service.buscarPorIdvisita(idvisita);
		model.addAttribute("visita", visita);
		obj.setFechahorasalida(fecha);
		
		return "/views/visita/registrar";
	}
	
}
