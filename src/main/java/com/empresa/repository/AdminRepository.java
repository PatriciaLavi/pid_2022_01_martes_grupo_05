package com.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.entity.Admin;



public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
