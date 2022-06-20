package com.empresa.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresa.DTO.BoletaDTO;
import com.empresa.DTO.ComboServicioDTO;
import com.empresa.DTO.DepartamentoDTO;
import com.empresa.DTO.NewServicioDTO;
import com.empresa.DTO.ServicioDTO;
import com.empresa.entity.Boleta;
import com.empresa.entity.ComboServicio;
import com.empresa.entity.Departamento;
import com.empresa.entity.Servicio;
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
	

	@GetMapping("/registrar")
	public String registrar(Model model) {
		List<Boleta> lstBoleta = boletaService.listarBoleta();
		List<BoletaDTO> newlstBoleta = new ArrayList<>();
		for(Boleta sv : lstBoleta) {
			BoletaDTO dto = new BoletaDTO();
			dto.setIdboleta(sv.getIdboleta());
			dto.setIdcomboservicio(sv.getIdcomboservicio().getNombreserv());
			dto.setIdpropietario(sv.getIdpropietario().getNombre());
			dto.setFechaEmision(sv.getFechaEmision());
			dto.setFechaVenc(sv.getFechaVenc());
			dto.setEstado(sv.getEstado());
			dto.setFechapago(sv.getFechapago());
			newlstBoleta.add(dto);
		}
	
		model.addAttribute("lstBoleta", newlstBoleta);
		
		return "/views/Boleta/registrar";
	}
	 
	
	
	
	
}
