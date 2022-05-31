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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.entity.Residente;
import com.empresa.entity.Visita;
import com.empresa.entity.Visitante;
import com.empresa.service.VisitaService;
import com.empresa.service.VisitanteService;

import lombok.extern.apachecommons.CommonsLog;


@Controller
@RequestMapping("/views/visita")
@CommonsLog
public class VisitaController {

	@Autowired
	private VisitaService service;

	
	@GetMapping("/")
	public String ListarVisita(Model model) {
		log.info("ListarVisita");
		List<Visita> lista = service.listarVisitas();
		model.addAttribute("titulo", "visitante");
		model.addAttribute("visita", lista);
		return "/views/visita/listar";
	}	

	
	

	@GetMapping("/registrar")
	public String RegistrarVisitantes(Model model) {
		log.info("RegistrarVisitantes");
	 Visita visita = new Visita();
	 model.addAttribute("visita", visita);
		
		return "/views/visita/registrar";
	}	
	

	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer idvisita ,Model model,@ModelAttribute Visita obj) {
		log.info("editar");
		Visita visita= service.buscarPorIdvisita(idvisita);
		model.addAttribute("visita", visita);
		return "/views/visita/actualizar";
	}
	@PostMapping("/update")
	public String Terminarvisista(@ModelAttribute Visita obj) {
		log.info("Terminarvisista");
		Visita visita= service.buscarPorIdvisita(obj.getIdvisita());
		visita.setFechahorasalida(new Date());
		visita.setComentario(obj.getComentario());
		service.insertaActualizaVistas(visita);
		return "redirect:/views/visita/";
	}
	
}
