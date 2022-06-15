package com.empresa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.repository.ServicioRepository;


@Service
public class ServicioServiceImp implements ServicioService{
	@Autowired
	private ServicioRepository repository;
}
