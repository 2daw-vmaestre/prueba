package com.ejemplos.models.dao;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ejemplos.DTO.MedicoDTO;
import com.ejemplos.models.entity.Auditoria;
import com.ejemplos.models.entity.Medico;


public interface IMedicoAuditoriaDao extends CrudRepository<Auditoria,Long> {
	
	@Query(value="SELECT m FROM MedicoAuditoria m WHERE FUNCTION('MONTH', m.fechaAuditoria)=MONTH(NOW())")
	Page<Medico> findByMedicoIdAndFechaAuditoriaAndActiva(boolean b,Specification<Medico> obtainFilterSpecification,
			Pageable pageable);

	@Query(value="SELECT m FROM MedicoAuditoria m WHERE FUNCTION('MONTH', m.fechaAuditoria)=MONTH(NOW())")
	Page<Medico> findByMedicoIdAndFechaAuditoria(Specification<Medico> obtainFilterSpecification, Pageable pageable);

//	List<MedicoDTO> findByMedicoIdAndFechaAuditoriaAndActiva(boolean b);




	
}

