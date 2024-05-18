package com.ejemplos.models.service;

import java.util.List;

import com.ejemplos.DTO.PacienteDTO;
import com.ejemplos.models.entity.Paciente;

public interface IPacienteService {
	
	public List<Paciente> findAll();
	
	public void save(Paciente producto);
	
	public Paciente findOne(Long id);
	
	public void delete(Long id);

	public PacienteDTO perfil(Long id);
	
}
