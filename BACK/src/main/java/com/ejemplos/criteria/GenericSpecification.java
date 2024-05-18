package com.ejemplos.criteria;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecification<T> implements Specification<T> {
	private List<SearchCriteria> criteria;

//	public GenericSpecification(SearchCriteria criteria) {
//		this.criteria = criteria;
//	}

//	public GenericSpecification(List<SearchCriteria> criteriaList) {
//		// TODO Auto-generated constructor stub
//	}
//	
	 public GenericSpecification(List<SearchCriteria> criteriaList) {
	        this.criteria = criteriaList;
	    }

	 @Override
	    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
	        List<Predicate> predicates = new ArrayList<>();

	        for (SearchCriteria criteria : criteria) {
	            if (criteria.getOperation().equalsIgnoreCase(">=")) {
	                if (criteria.getValue() instanceof LocalTime) {
	                    predicates.add(builder.greaterThan(root.get(criteria.getKey()), (LocalTime) criteria.getValue()));
	                } else {
	                    predicates.add(builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
	                }
	            } else if (criteria.getOperation().equalsIgnoreCase("<=")) {
	                if (criteria.getValue() instanceof LocalTime) {
	                    predicates.add(builder.lessThan(root.get(criteria.getKey()), (LocalTime) criteria.getValue()));
	                } else {
	                    predicates.add(builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
	                }
	            } else if (criteria.getOperation().equalsIgnoreCase(":")) {
	                if (root.get(criteria.getKey()).getJavaType() == String.class) {
	                    predicates.add(builder.like(root.get(criteria.getKey()), "%" + criteria.getValue() + "%"));
	                } else if (root.get(criteria.getKey()).getJavaType() == LocalTime.class) {
	                	 String formattedTime = ((LocalTime) criteria.getValue()).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	                     predicates.add(builder.equal(root.get(criteria.getKey()), formattedTime));	              
	                     } else {
	                    predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
	                }
	            } else if (criteria.getOperation().equalsIgnoreCase("==")) {
	                predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
	            }
	        }
	        return builder.and(predicates.toArray(new Predicate[0]));
	    }
}
