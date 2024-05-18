package com.ejemplos.models.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.ejemplos.models.entity.RespuestaMedico;

/*Una clase Service está basada en el patrón de diseño Facade:
  un único punto de acceso a clases DAO. Por cada clase DAO hay una clase Service*/

@Service
public class RespuestaMedicoServiceImpl implements IRespuestaMedicoService {

	@Override
	public List<RespuestaMedico> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(RespuestaMedico cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RespuestaMedico findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
		
		
		
}
