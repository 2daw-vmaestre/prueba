package com.ejemplos.models.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ejemplos.models.dao.IAuditoriaDao;
import com.ejemplos.models.entity.Respuesta;




@Service
public class RespuestaServiceImpl implements IRespuestaService {

	@Override
	public List<Respuesta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Respuesta producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Respuesta findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
		
}
