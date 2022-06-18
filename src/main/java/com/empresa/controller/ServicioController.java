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

import com.empresa.DTO.ComboServicioDTO;
import com.empresa.DTO.DepartamentoDTO;
import com.empresa.DTO.NewServicioDTO;
import com.empresa.DTO.ServicioDTO;
import com.empresa.entity.ComboServicio;
import com.empresa.entity.Departamento;
import com.empresa.entity.Servicio;
import com.empresa.service.ComboServicioService;
import com.empresa.service.DepartamentoService;
import com.empresa.service.ServicioService;


@Controller
@RequestMapping("/views/servicio")

public class ServicioController {
	@Autowired
	private ServicioService servicioService;
	@Autowired
	private DepartamentoService departamentoservice;
	@Autowired
	private ComboServicioService comboServicioService;
	
	
	@GetMapping("/registrar")
	public String registrar(Model model) {
		List<Departamento> lista = departamentoservice.listarDptos();
		List<DepartamentoDTO> newslstDepartamento = new ArrayList<>();
		for(Departamento vst : lista)
		{
			DepartamentoDTO dtodep = new DepartamentoDTO();
			dtodep.setIddepartamento(vst.getIddepartamento());
			dtodep.setNumdepartamento(vst.getNumdepartamento());
			newslstDepartamento.add(dtodep);	
		}
		List<ComboServicio> lista2 = comboServicioService.getAllComboServicio();
		List<ComboServicioDTO> newslstComboServicios = new ArrayList<>();
		for(ComboServicio vst : lista2)
		{
			ComboServicioDTO dtoSer = new ComboServicioDTO();
			dtoSer.setIdComboservicio(vst.getIdComboservicio());
			dtoSer.setNombreserv(vst.getNombreserv());
			newslstComboServicios.add(dtoSer);	
		}
		List<Servicio> lstServicio = servicioService.getAllServicio();
		List<ServicioDTO> newlstServicio = new ArrayList<>();
		for(Servicio sv : lstServicio) {
			ServicioDTO dto = new ServicioDTO();
			dto.setIdservicio(sv.getIdservicio());
			dto.setIddepartamento(sv.getIddepartamento().getNumdepartamento());
			dto.setIdcomboservicio(sv.getIdcomboservicio().getNombreserv());
			dto.setPrecioserv(sv.getPrecioserv());
			dto.setFechareg(sv.getFechareg());
			dto.setEstado(sv.getEstado());
			newlstServicio.add(dto);
		}
		Servicio servicio=new Servicio();
		model.addAttribute("servicio", servicio);
		model.addAttribute("cboDepartamentos", newslstDepartamento);
		model.addAttribute("cboServicios", newslstComboServicios);
		model.addAttribute("lstservicio", newlstServicio);
		
		return "/views/servicio/registrar";
	}
	  @PostMapping("/save")
		public String Guardar(@ModelAttribute Servicio obj,Model model, NewServicioDTO body) {	
		  Double getPrecio = 0.0;
		  String StgPrecio = comboServicioService.buscarPrecioxId(body.getIdcomboservicio()).toString();
		  Departamento getDepartamento = departamentoservice.getServicioId(body.getIddepartamento()).orElse(null);
		  if(StgPrecio.length()==14) {
			  getPrecio = Double.parseDouble(StgPrecio.substring(9,13)); 
		  }else {
			  getPrecio = Double.parseDouble(StgPrecio.substring(9,12));
		  }
		  ComboServicio getComboServicio = comboServicioService.getIdComboServicio(body.getIdcomboservicio()).orElse(null);
		  
			Date nowDate = new Date();
			Servicio newServicio = new Servicio();
			newServicio.setIddepartamento(getDepartamento);
			newServicio.setIdcomboservicio(getComboServicio);
			newServicio.setPrecioserv(getPrecio);
			newServicio.setFechareg(nowDate);
			newServicio.setEstado("Activo");
			
			servicioService.insertaActualizaServicio(newServicio);
			return "redirect:/views/servicio/registrar";
		}
	
	
}
