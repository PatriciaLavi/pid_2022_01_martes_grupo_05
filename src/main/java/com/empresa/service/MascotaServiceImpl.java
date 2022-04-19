package com.empresa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Mascota;
import com.empresa.repository.MascotaRepository;
@Service
public class MascotaServiceImpl implements MascotaService {

	@Autowired
	private MascotaRepository repository;
	@Override
	public List<Mascota> listarMascota() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	@Override
	public Mascota insertaMascota(Mascota obj) {
		// TODO Auto-generated method stub
		return repository.save(obj);
	}

}
