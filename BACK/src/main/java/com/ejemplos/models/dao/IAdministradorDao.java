package com.ejemplos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ejemplos.models.entity.Administrador;

public interface IAdministradorDao extends CrudRepository<Administrador,Long> {

}