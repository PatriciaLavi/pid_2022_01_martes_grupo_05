package com.empresa.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empresa.DTO.BoletaDTO;
import com.empresa.DTO.ComboServicioDTO;
import com.empresa.DTO.DepartamentoDTO;
import com.empresa.DTO.NewBoletaDTO;
import com.empresa.DTO.NewServicioDTO;
import com.empresa.DTO.PropiertarioDTO;
import com.empresa.DTO.ServicioDTO;
import com.empresa.entity.Boleta;
import com.empresa.entity.ComboServicio;
import com.empresa.entity.Departamento;
import com.empresa.entity.Propietario;
import com.empresa.entity.Servicio;
import com.empresa.entity.Visita;
import com.empresa.entity.Visitante;
import com.empresa.service.BoletaService;
import com.empresa.service.ComboServicioService;
import com.empresa.service.DepartamentoService;
import com.empresa.service.PropietarioService;
import com.empresa.service.ServicioService;

import lombok.extern.apachecommons.CommonsLog;

@Controller
@RequestMapping("/views/boleta")

public class BoletaController {
	@Autowired
	private BoletaService boletaService;
	@Autowired
	private PropietarioService propietarioService;
	@Autowired
	private ComboServicioService comboServicioService;
	@Autowired
	private DepartamentoService departamentoservice;
	

	@GetMapping("/registrar")
	public String registrar(Model model) {
		List<ComboServicio> lista2 = comboServicioService.getAllComboServicio();
		List<ComboServicioDTO> newslstComboServicios = new ArrayList<>();
		for(ComboServicio vst : lista2)
		{
			ComboServicioDTO dtoSer = new ComboServicioDTO();
			dtoSer.setIdComboservicio(vst.getIdComboservicio());
			dtoSer.setNombreserv(vst.getNombreserv());
			newslstComboServicios.add(dtoSer);	
		}
		List<Departamento> lista = departamentoservice.listarDptos();
		List<DepartamentoDTO> newslstDepartamento = new ArrayList<>();
		for(Departamento vst : lista)
		{
			DepartamentoDTO dtodep = new DepartamentoDTO();
			dtodep.setIddepartamento(vst.getIddepartamento());
			dtodep.setNumdepartamento(vst.getNumdepartamento());
			newslstDepartamento.add(dtodep);	
		}
		List<Propietario> lstPropietario = propietarioService.getPropietario();
		List<PropiertarioDTO> newslstPropietario = new ArrayList<>();
		for(Propietario pr  : lstPropietario)
		{
			PropiertarioDTO dtoprop = new PropiertarioDTO();
			dtoprop.setIdPropietario(pr.getIdPropietario());
			dtoprop.setNombre(pr.getNombre()+ " "+ pr.getApellidos());
			newslstPropietario.add(dtoprop);	
		}
		List<Boleta> lstBoleta = boletaService.listarBoleta();
		List<BoletaDTO> newlstBoleta = new ArrayList<>();
		for(Boleta sv : lstBoleta) {
			BoletaDTO dto = new BoletaDTO();
			dto.setIdboleta(sv.getIdboleta());
			dto.setIdcomboservicio(sv.getIdcomboservicio().getNombreserv());
			dto.setPrecioserv(sv.getPrecioserv());
			dto.setIdpropietario(sv.getIdpropietario().getNombre());
			dto.setIddepartamento(sv.getIddepartamento().getNumdepartamento());
			dto.setFechaEmision(sv.getFechaEmision());
			dto.setFechaVenc(sv.getFechaVenc());
			dto.setEstado(sv.getEstado());
			dto.setFechapago(sv.getFechapago());
			newlstBoleta.add(dto);
		}

		Boleta boleta = new Boleta();
		model.addAttribute("boleta", boleta);
		model.addAttribute("lstBoleta", newlstBoleta);
		model.addAttribute("cboComboServicios", newslstComboServicios);
		model.addAttribute("cboDepartamento", newslstDepartamento);
		model.addAttribute("cboPropietario", newslstPropietario);
			return "/views/Boleta/registrar";
	}
	

	 @PostMapping("/save")
		public String Guardar(@ModelAttribute Boleta obj,Model model, NewBoletaDTO body) {	
		  Double getPrecio = 0.0;
		  ComboServicio getComboServicio = comboServicioService.getIdComboServicio(body.getIdcomboservicio()).orElse(null);
		  String StgPrecio = comboServicioService.buscarPrecioxId(body.getIdcomboservicio()).toString();
		  Departamento getDepartamento = departamentoservice.getServicioId(body.getIddepartamento()).orElse(null);
		  if(StgPrecio.length()==14) {
			  getPrecio = Double.parseDouble(StgPrecio.substring(9,13)); 
		  }else {
			  getPrecio = Double.parseDouble(StgPrecio.substring(9,12));
		  }
		  
		  Propietario getPropietario = propietarioService.getPropiertarioxID(body.getIdpropietario()).orElse(null);
		  Date nowDate = new Date();
		  Calendar calendar = Calendar.getInstance();
		  calendar.setTime(nowDate); 
		  calendar.add(Calendar.DAY_OF_YEAR, 30);
			
			Boleta newBoleta = new Boleta();
			newBoleta.setIdcomboservicio(getComboServicio);
			newBoleta.setPrecioserv(getPrecio);
			newBoleta.setIdpropietario(getPropietario);
			newBoleta.setIddepartamento(getDepartamento);
			newBoleta.setFechaEmision(nowDate);
			newBoleta.setFechaVenc(formatearCalendar(calendar));
			newBoleta.setEstado("Pendiente");
			boletaService.insertaActualizaBoleta(newBoleta);
			return "redirect:/views/boleta/registrar";
		}
	
	 public static String formatearCalendar(Calendar c) {
		 
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			return df.format(c.getTime());
	}
	 
	 
	 
	 @GetMapping("/consulta")
		public String consultaBoleta(Model model) {
		 List<Boleta> lstBoleta = boletaService.listarBoleta();
			List<BoletaDTO> newlstBoleta = new ArrayList<>();
			for(Boleta sv : lstBoleta) {
				BoletaDTO dto = new BoletaDTO();
				dto.setIdboleta(sv.getIdboleta());
				dto.setIdcomboservicio(sv.getIdcomboservicio().getNombreserv());
				dto.setPrecioserv(sv.getPrecioserv());
				dto.setIdpropietario(sv.getIdpropietario().getNombre());
				dto.setIddepartamento(sv.getIddepartamento().getNumdepartamento());
				dto.setFechaEmision(sv.getFechaEmision());
				dto.setFechaVenc(sv.getFechaVenc());
				dto.setEstado(sv.getEstado());
				dto.setFechapago(sv.getFechapago());
				newlstBoleta.add(dto);
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
			List<Departamento> lista = departamentoservice.listarDptos();
			List<DepartamentoDTO> newslstDepartamento = new ArrayList<>();
			for(Departamento vst : lista)
			{
				DepartamentoDTO dtodep = new DepartamentoDTO();
				dtodep.setIddepartamento(vst.getIddepartamento());
				dtodep.setNumdepartamento(vst.getNumdepartamento());
				newslstDepartamento.add(dtodep);	
			}
			List<Propietario> lstPropietario = propietarioService.getPropietario();
			List<PropiertarioDTO> newslstPropietario = new ArrayList<>();
			for(Propietario pr  : lstPropietario)
			{
				PropiertarioDTO dtoprop = new PropiertarioDTO();
				dtoprop.setIdPropietario(pr.getIdPropietario());
				dtoprop.setNombre(pr.getNombre()+ " "+ pr.getApellidos());
				newslstPropietario.add(dtoprop);	
			}	
			model.addAttribute("lstBoleta", newlstBoleta);
			model.addAttribute("boleta", new Boleta());
			model.addAttribute("cboComboServicios", newslstComboServicios);
			model.addAttribute("cboDepartamento", newslstDepartamento);
			model.addAttribute("cboPropietario", newslstPropietario);
			return "/views/boleta/consulta";
		}
	 
	 
	 @GetMapping("/filtro")
		public String buscarPorDNI( 
				@RequestParam(name = "idcomboservicio" ,required = false, defaultValue = "" ) int idcomboservicio,
				@RequestParam(name = "idpropietario" ,required = false, defaultValue = "" ) int idpropietario,
				@RequestParam(name = "iddepartamento" ,required = false, defaultValue = "" ) int iddepartamento,
				Model model) {
		 try {
				List<Boleta> lstBoleta = boletaService.getBoletaxServicioPropietarioDepartamento(idcomboservicio,idpropietario,iddepartamento);
				List<BoletaDTO> newlstBoleta = new ArrayList<>();
				for(Boleta sv : lstBoleta) {
					BoletaDTO dto = new BoletaDTO();
					dto.setIdboleta(sv.getIdboleta());
					dto.setIdcomboservicio(sv.getIdcomboservicio().getNombreserv());
					dto.setPrecioserv(sv.getPrecioserv());
					dto.setIdpropietario(sv.getIdpropietario().getNombre());
					dto.setIddepartamento(sv.getIddepartamento().getNumdepartamento());
					dto.setFechaEmision(sv.getFechaEmision());
					dto.setFechaVenc(sv.getFechaVenc());
					dto.setEstado(sv.getEstado());
					dto.setFechapago(sv.getFechapago());
					newlstBoleta.add(dto);
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
				List<Departamento> lista = departamentoservice.listarDptos();
				List<DepartamentoDTO> newslstDepartamento = new ArrayList<>();
				for(Departamento vst : lista)
				{
					DepartamentoDTO dtodep = new DepartamentoDTO();
					dtodep.setIddepartamento(vst.getIddepartamento());
					dtodep.setNumdepartamento(vst.getNumdepartamento());
					newslstDepartamento.add(dtodep);	
				}
				List<Propietario> lstPropietario = propietarioService.getPropietario();
				List<PropiertarioDTO> newslstPropietario = new ArrayList<>();
				for(Propietario pr  : lstPropietario)
				{
					PropiertarioDTO dtoprop = new PropiertarioDTO();
					dtoprop.setIdPropietario(pr.getIdPropietario());
					dtoprop.setNombre(pr.getNombre()+ " "+ pr.getApellidos());
					newslstPropietario.add(dtoprop);	
				}
				if(lstBoleta.size()<1) {
					model.addAttribute("boleta", new Boleta());
					model.addAttribute("cboComboServicios", newslstComboServicios);
					model.addAttribute("cboDepartamento", newslstDepartamento);
					model.addAttribute("cboPropietario", newslstPropietario);
					model.addAttribute("lstBoleta", newlstBoleta);
					model.addAttribute("mensaje","No existen datos");
				}else {
					
					model.addAttribute("boleta", new Boleta());
					model.addAttribute("cboComboServicios", newslstComboServicios);
					model.addAttribute("cboDepartamento", newslstDepartamento);
					model.addAttribute("cboPropietario", newslstPropietario);
					model.addAttribute("lstBoleta", newlstBoleta);
					model.addAttribute("mensaje","Existen" + lstBoleta.size()+"para mostrar");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
					return "/views/boleta/consulta";
		}
	 @GetMapping("/edit/{id}")
		public String editar(@PathVariable ("id") Integer idBoleta ,Model model,@ModelAttribute Boleta obj) {
			Boleta boleta=boletaService.getBoletaxId(idBoleta);
			model.addAttribute("boleta", boleta);
			return "/views/boleta/finalizar";
		}
		@PostMapping("/update")
		public String Terminarvisista(@ModelAttribute Boleta obj,Model model) {
			 List<Boleta> lstBoleta = boletaService.listarBoleta();
				List<BoletaDTO> newlstBoleta = new ArrayList<>();
				for(Boleta sv : lstBoleta) {
					BoletaDTO dto = new BoletaDTO();
					dto.setIdboleta(sv.getIdboleta());
					dto.setIdcomboservicio(sv.getIdcomboservicio().getNombreserv());
					dto.setPrecioserv(sv.getPrecioserv());
					dto.setIdpropietario(sv.getIdpropietario().getNombre());
					dto.setIddepartamento(sv.getIddepartamento().getNumdepartamento());
					dto.setFechaEmision(sv.getFechaEmision());
					dto.setFechaVenc(sv.getFechaVenc());
					dto.setEstado(sv.getEstado());
					dto.setFechapago(sv.getFechapago());
					newlstBoleta.add(dto);
				}
			Boleta newBoleta = boletaService.getBoletaxId(obj.getIdboleta());
			Date date = new Date();
			newBoleta.setFechapago(date);
			newBoleta.setEstado("Cancelado");
			boletaService.insertaActualizaBoleta(newBoleta);
			model.addAttribute("lstBoleta", newlstBoleta);
			return "/views/boleta/consulta";
		}
	 
	
	
	
	
}
