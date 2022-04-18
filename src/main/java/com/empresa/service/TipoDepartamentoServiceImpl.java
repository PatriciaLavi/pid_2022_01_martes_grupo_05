package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.tipoDepartamento;
import com.empresa.repository.TipoDepartamentoRepository;


@Service
public class TipoDepartamentoServiceImpl implements TipoDepartamentoService {

	@Autowired
	private TipoDepartamentoRepository repository;
	@Override
	public List<tipoDepartamento> listarTiposDepartamentos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
