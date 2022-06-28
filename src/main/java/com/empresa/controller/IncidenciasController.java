package com.empresa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.DTO.BoletaDTO;
import com.empresa.DTO.DepartamentoDTO;
import com.empresa.DTO.IncidenciaDTO;
import com.empresa.entity.Boleta;
import com.empresa.entity.Departamento;
import com.empresa.entity.Incidencias;
import com.empresa.entity.Residente;
import com.empresa.service.DepartamentoService;
import com.empresa.service.IncidenciasService;
import com.empresa.service.ResidenteService;

@Controller
@RequestMapping("/views/incidencias/")
public class IncidenciasController {
	
	@Autowired
	private IncidenciasService incidenciasService;
	@Autowired
	private ResidenteService residenteservice;
	@Autowired
	private DepartamentoService departamentoservice;
	
	
	
	
	
	@GetMapping("/")
	
	public String listarInc(Model model) {
		
		List<Incidencias> lstInci = incidenciasService.listarInc();
		List<IncidenciaDTO> newlstIncidencia = new ArrayList<>();
		for(Incidencias sv : lstInci) {
			IncidenciaDTO dto = new IncidenciaDTO();
			dto.setIdincidencia(sv.getIdincidencia());
			dto.setIddepartamento(sv.getIddepartamento().getNumdepartamento());
			dto.setTipo(sv.getTipo());
			dto.setEstado(sv.getEstado());
			dto.setCausa(sv.getCausa());
			dto.setDescripcion(sv.getDescripcion());
			
			newlstIncidencia.add(dto);
		}
	
		
		model.addAttribute("titulo","Lista de incidencias");
		model.addAttribute("incidencias", newlstIncidencia);
		
		return "/views/incidencias/listar";
	}
	
	@GetMapping("filtro")
	public String filtro(@RequestParam(name = "iddepartamento" ,required = false, defaultValue = "" ) int iddepartamento,
			Model model) {
		
	try {	
		
	List<Incidencias> lstInci = incidenciasService.buscarPorDep(iddepartamento);
	List<IncidenciaDTO> newlstIncidencia = new ArrayList<>();
	for(Incidencias sv : lstInci) {
		IncidenciaDTO dto = new IncidenciaDTO();
		dto.setIdincidencia(sv.getIdincidencia());
		dto.setIddepartamento(sv.getIddepartamento().getNumdepartamento());
		dto.setTipo(sv.getTipo());
		dto.setEstado(sv.getEstado());
		dto.setCausa(sv.getCausa());
		dto.setDescripcion(sv.getDescripcion());
		newlstIncidencia.add(dto);
	
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
	
	if(lstInci.size()> 0) {
		model.addAttribute("Incidencia", new Boleta());
		model.addAttribute("cboDepartamento", newslstDepartamento);
		model.addAttribute("lstInc", newlstIncidencia);
		model.addAttribute("mensaje","Existen" + lstInci.size()+"para mostrar");
	}
	}
	
	catch (Exception e) {
		e.printStackTrace();
	}
	return "/views/incidencias/flitrar";
	}
	
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
		Incidencias incidencias = new Incidencias();
		model.addAttribute("incidencias", incidencias);
		model.addAttribute("cboDepartamento", newslstDepartamento);
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
