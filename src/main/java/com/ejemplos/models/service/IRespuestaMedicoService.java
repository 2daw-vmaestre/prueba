package com.ejemplos.models.service;

import java.util.List;

import com.ejemplos.models.entity.RespuestaMedico;


public interface IRespuestaMedicoService {
	
	public List<RespuestaMedico> findAll();
	
	public void save(RespuestaMedico producto);
	
	public RespuestaMedico findOne(Long id);
	
	public void delete(Long id);
	
}
