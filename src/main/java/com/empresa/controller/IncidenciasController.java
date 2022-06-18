package com.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Incidencias;
import com.empresa.entity.Residente;
import com.empresa.service.IncidenciasService;
import com.empresa.service.ResidenteService;

@Controller
@RequestMapping("/views/incidencias/")
public class IncidenciasController {
	
	@Autowired
	private IncidenciasService incidenciasService;
	@Autowired
	private ResidenteService residenteservice;
	
	@GetMapping("/")
	
	public String listarDptos(Model model) {
		List<Incidencias> listadoIncidencias = incidenciasService.listarInc();
		
		model.addAttribute("titulo","Lista de incidencias");
		model.addAttribute("incidencias", listadoIncidencias);
		return "/views/incidencias/listar";
	}
	
	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		Incidencias incidencias = new Incidencias();
		model.addAttribute("incidencias", incidencias);
		return "/views/incidencias/registrar";
	}
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Incidencias incidencias) {
		
		incidenciasService.guardar(incidencias);
		System.out.println("Incidencia guardada Exitosamente");
		return "redirect:/views/incidencias/";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer idincidencia ,Model model) {
		
		Incidencias incidencias = incidenciasService.buscarPorId(idincidencia);
		
		model.addAttribute("incidencias", incidencias);
		
		return "/views/incidencias/registrar";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Integer idincidencia) {
		
		incidenciasService.eliminar(idincidencia);
		System.out.println("Registro eliminado exitosamente");
		
		return "redirect:/views/incidencias/";
	}
	
	@RequestMapping("/cargaResidente")
	@ResponseBody
	public List<Residente> listarResidentes(){
		return residenteservice.listarResidentes();
	}

}
