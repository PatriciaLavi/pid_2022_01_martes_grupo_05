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
import java.util.ArrayList;
import com.empresa.DTO.VisitaDTO;
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
		
		List<Visita> lista = service.getVisita();
		List<VisitaDTO> newslstVisita = new ArrayList<>();
		for(Visita vs : lista)
		{
			VisitaDTO dto = new VisitaDTO();
			dto.setIdvisita(vs.getIdvisita());
			dto.setIdvisitante(vs.getIdvisitante().getNombre()+" "+vs.getIdvisitante().getApellidos());
			dto.setDni(vs.getDni());
			dto.setIdresidente(vs.getIdresidente().getNombre()+" "+vs.getIdresidente().getApellidos());
			dto.setFrmFechaHoraEntrada(vs.getFrmFechaHoraEntrada());
			dto.setFrmFechaHoraSalida(vs.getFrmFechaHoraSalida());
			dto.setComentario(vs.getComentario());
			newslstVisita.add(dto);
			
			
		}
		model.addAttribute("titulo", "visitante");
		model.addAttribute("visita", newslstVisita);
		return "/views/visita/listar";
	}		

	@GetMapping("/consulta")
	public String consultaVisitas(Model model) {
		model.addAttribute("visita", new Visita());
		return "/views/visita/consulta";
	}	
	@GetMapping("/dni")
	public String buscarPorDNI(@RequestParam String dni, Model model, @ModelAttribute("visita") Visita visita) {
		model.addAttribute("visitaLista", service.ListaPorDni(dni));
		
		return "/views/visita/consulta";
	}
	

	@GetMapping("/registrar")
	public String RegistrarVisitantes(Model model) {
		log.info("RegistrarVisitantes");
	 Visita visita = new Visita();
	 model.addAttribute("visita", visita);
		
		return "/views/visita/registrar";
	}	
	

     @PostMapping("/save")
	public String Guardar(@ModelAttribute Visita obj, String dni, Model model) {	
		if(service.existsByDni(dni)) {
			model.addAttribute("dniRepetido","El dni ya existe");
			return "/views/visita/registrar";
		}		
		log.info("Guardar");
		obj.setFechahoraentrada(new Date());
		service.insertaActualizaVistas(obj);
		return "redirect:/views/visita/";
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
