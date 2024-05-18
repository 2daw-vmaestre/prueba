package com.ejemplos.models.dao;

import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.ejemplos.DTO.MedicoFilterDTO;
import com.ejemplos.models.entity.Medico;

public interface IMedicoDao extends JpaRepository<Medico, Long>, JpaSpecificationExecutor<Medico> {

//	List<Medico> findByActivo(boolean activa);

	Optional<Medico> findByNumeroIdentificacionAndActivo(String username, Boolean activo);

	@Query(value="SELECT m from Medico m")
	Page<Medico> findByActivo(Specification<Medico> obtainFilterSpecification, Pageable pageable);

	Page<Medico> findAll(Predicate predicate, Pageable pageable);

	
	//Page<Medico> findByMedicoIdAndFechaAuditoria(MedicoFilterDTO medicoFilterDTO, Pageable pageable);

}
