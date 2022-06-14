package com.empresa.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;

import com.empresa.DTO.NewVisitaDTO;
import com.empresa.DTO.ResidenteDTO;
import com.empresa.DTO.VisitaDTO;
import com.empresa.DTO.VisitanteDTO;
import com.empresa.entity.Residente;
import com.empresa.entity.Visita;
import com.empresa.entity.Visitante;
import com.empresa.service.ResidenteService;
import com.empresa.service.VisitaService;
import com.empresa.service.VisitanteService;

import lombok.extern.apachecommons.CommonsLog;


@Controller
@RequestMapping("/views/visita")
@CommonsLog
public class VisitaController {

	@Autowired
	private VisitaService service;
	@Autowired
	private VisitanteService visitanteservice;
	@Autowired
	private ResidenteService residenteservice;
	

	
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
			dto.setEstado(vs.isEstado());
			
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
		List<Visitante> lista = visitanteservice.getVisitante();
		List<VisitanteDTO> newslstVisitante = new ArrayList<>();
		for(Visitante vst : lista)
		{
			VisitanteDTO dto = new VisitanteDTO();
			dto.setIdvisitante(vst.getIdvisitante());
			dto.setNombre(vst.getNombre()+" "+vst.getApellidos());
			newslstVisitante.add(dto);	
		}
		List<Residente> lista2 = residenteservice.getResidente();
		List<ResidenteDTO> newslstResidente = new ArrayList<>();
		for(Residente rs : lista2)
		{
			ResidenteDTO dto2 = new ResidenteDTO();
			dto2.setIdResidente(rs.getIdResidente());
			dto2.setNombre(rs.getNombre()+" "+rs.getApellidos());
			newslstResidente.add(dto2);	
		}
		model.addAttribute("visitantes", newslstVisitante);
		model.addAttribute("Residentes", newslstResidente);
	 Visita visita = new Visita();
	 model.addAttribute("visita", visita);
		
		return "/views/visita/registrar";
	}	
	

     @PostMapping("/save")
	public String Guardar(@ModelAttribute Visita obj, String dni, Integer idvisitante, Model model, NewVisitaDTO body) {	
		Visitante getvisitante = visitanteservice.getVisitanteId(body.getIdvisitante()).orElse(null);
		Residente getResidente = residenteservice.getResidenteId(body.getIdresidente()).orElse(null);
		Date nowDate = new Date();
		if(body.getIdvisitante()==0) {
			model.addAttribute("dniRepetido","No se encontro dni");
		}else if(body.getIdresidente()==0) {
			model.addAttribute("dniRepetido","No se encontro Residente");
		}else if(!(service.getEstado(idvisitante)== null)) {
			model.addAttribute("dniRepetido","XD");
		}else if(service.existsByDni(dni)) {
			model.addAttribute("dniRepetido","El visitante ya se encuentra en una visita");
			return "/views/visita/registrar";
		}		
		log.info("Guardar");
		Visita newVisita = new Visita();
		newVisita.setIdvisitante(getvisitante);
		newVisita.setDni(body.getDni());
		newVisita.setIdresidente(getResidente);
		newVisita.setFechahoraentrada(nowDate);
		service.insertaActualizaVistas(newVisita);
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
