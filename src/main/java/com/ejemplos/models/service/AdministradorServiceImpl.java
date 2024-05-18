package com.ejemplos.models.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejemplos.models.dao.IAdministradorDao;
import com.ejemplos.models.entity.Administrador;

@Service
public class AdministradorServiceImpl implements IAdministradorService {

	@Override
	public List<Administrador> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Administrador cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Administrador findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	
		
		
		
}
