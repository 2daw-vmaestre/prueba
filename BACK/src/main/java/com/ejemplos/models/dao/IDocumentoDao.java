package com.ejemplos.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.ejemplos.models.entity.Auditoria;


public interface IDocumentoDao extends CrudRepository<Auditoria,Long> {
	
}
