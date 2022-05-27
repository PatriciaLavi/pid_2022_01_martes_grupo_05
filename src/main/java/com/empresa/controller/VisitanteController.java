package com.empresa.controller;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.empresa.entity.Visitante;
import com.empresa.service.VisitaService;
import com.empresa.service.VisitanteService;

@Controller
@RequestMapping("/views/vistante")
public class VisitanteController {

	@Autowired
	private VisitanteService service;

	@Secured("ROLE_USER")
	@GetMapping("/")
	public String ListarVisitantes(Model model) {
		List<Visitante> lista = service.listarVisitante();	
		model.addAttribute("titulo", "visitante");
		model.addAttribute("visitante", lista);
		return "/views/vistante/listar";
	}
	@Secured("ROLE_USER")
	@GetMapping("/registrar")
	public String RegistrarVisitantes(Model model) {
		Visitante visitante = new Visitante();	
		model.addAttribute("visitante", visitante);
		return "/views/vistante/registrar";
	}
	@Secured("ROLE_USER")
	@PostMapping("/save")
	public String Guardar(@ModelAttribute Visitante obj) {	
		obj.setActivo("Activo");
		service.insertaActualizaVistante(obj);
		return "redirect:/views/vistante/";
	}

	@Secured("ROLE_GERENTE")
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable ("id") Integer id ,Model model) {
		
		Visitante vist = service.buscarPorId(id);
		
		
		model.addAttribute("visitante", vist);
		
		return "/views/vistante/registrar";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable ("id") Integer id) {
		
		Visitante visit=service.buscarPorId(id);
		visit.setActivo("Dentro");
		service.insertaActualizaVistante(visit);
		return "redirect:/views/vistante/";
	}
	@GetMapping("/listarparametros")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> listaParametros(
			Model model,
			@RequestParam(name = "nombre" ,required = false, defaultValue = "" ) String nombre,
			@RequestParam(name = "apellidos" ,required = false, defaultValue = "" ) String apellidos,
			@RequestParam(name = "dni" ,required = false, defaultValue = "" ) String dni
			){
		Map<String, Object> salida = new HashMap<>();
		try {
			List<Visitante> lista = service.listaVisitantePorNombreDni("%"+nombre+"%","%"+ apellidos+"%", "%"+dni+"%");
			if(org.springframework.util.CollectionUtils.isEmpty(lista)) {
				salida.put("mensaje", "No existen datos");
			}else {
				salida.put("lista", lista);
				salida.put("Mensaje", "Existen" + lista.size()+"para mostrar");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
				return null;
		
		
	}

	
	
}
