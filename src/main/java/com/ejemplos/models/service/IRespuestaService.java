package com.ejemplos.models.service;

import java.util.List;

import com.ejemplos.models.entity.Respuesta;

public interface IRespuestaService {
	
	public List<Respuesta> findAll();
	
	public void save(Respuesta producto);
	
	public Respuesta findOne(Long id);
	
	public void delete(Long id);
	
}
