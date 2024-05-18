package com.ejemplos.models.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.ejemplos.DTO.PacienteDTO;
import com.ejemplos.models.entity.Paciente;

/*Una clase Service está basada en el patrón de diseño Facade:
  un único punto de acceso a clases DAO. Por cada clase DAO hay una clase Service*/

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Override
	public List<Paciente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Paciente producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paciente findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PacienteDTO perfil(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
		
		
		
}
