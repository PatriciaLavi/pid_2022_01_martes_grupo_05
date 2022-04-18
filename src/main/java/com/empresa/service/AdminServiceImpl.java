package com.empresa.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entity.Admin;
import com.empresa.repository.AdminRepository;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository repository;
	@Override
	public List<Admin> ListarAdmin() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
