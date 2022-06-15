package com.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresa.service.ServicioService;

import lombok.extern.apachecommons.CommonsLog;


@Controller
@RequestMapping("/views/servicio")

public class ServicioController {
	@Autowired
	private ServicioService servicioService;
	
}
