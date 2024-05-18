package com.ejemplos.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.ejemplos.models.entity.Auditoria;


public interface IConsultaCitaDao extends CrudRepository<Auditoria,Long> {
	
}
