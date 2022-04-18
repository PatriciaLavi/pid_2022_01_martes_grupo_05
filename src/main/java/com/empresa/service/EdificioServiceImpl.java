package com.empresa.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Edificio;
import com.empresa.repository.EdificioRepository;



@Service
public class EdificioServiceImpl implements EdificioService {
	@Autowired
	private EdificioRepository repository;
	@Override
	public List<Edificio> listarEdificios() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
