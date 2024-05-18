package com.ejemplos.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

import com.ejemplos.models.entity.Medico;

@Service
public abstract class GenericService<T>{
	

	    @Autowired
	    private JpaRepository<T, Long> repository;
//	    
	    @Autowired
	    private JpaSpecificationExecutor<T> specificationExecutor;
	    @Autowired
	    private EntityManager entityManager;

	    public List<T> buscarMedicos(Specification<T> spec) {
	        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	        CriteriaQuery<T> query = (CriteriaQuery<T>) builder.createQuery(Medico.class);
	        Root<T> root = (Root<T>) query.from(Medico.class);
	        
	        Predicate predicate = spec.toPredicate(root, query, builder);
	        query.where(predicate);
	        
	        return entityManager.createQuery(query).getResultList();
	    }
	    
	}


