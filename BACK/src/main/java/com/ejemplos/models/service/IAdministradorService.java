package com.ejemplos.models.service;

import java.util.List;

import com.ejemplos.models.entity.Administrador;



public interface IAdministradorService {
	
	public List<Administrador> findAll();
	
	public void save(Administrador cliente);
	
	public Administrador findOne(Long id);
	
	public void delete(Long id);
	

	
}
