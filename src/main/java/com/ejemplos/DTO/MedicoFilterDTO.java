package com.ejemplos.DTO;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Component
public class MedicoFilterDTO {

	private String nombre;
	private String apellidos;
	@JsonFormat(pattern = "HH:mm")
	private String jornadaFinal;
	@JsonFormat(pattern = "HH:mm")
	private String jornadaInicio;
	private String numeroIdentificacion;

//	@Override
//	public Predicate toPredicate(Root<Medico> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Predicate toPredicate(Root<Medico> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//	    List<Predicate> predicates = new ArrayList<>();
//
//	    // Filtro por nombre
//	    if (StringUtils.isNotBlank(this.nombre)) {
//	        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nombre")), "%" + nombre.toLowerCase() + "%"));
//	    }
//
//	    // Filtro por hora de inicio
//	    if (this.jornadaInicio != null) {
//	        predicates.add(criteriaBuilder.equal(root.get("jornadaInicio"), jornadaInicio));
//	    }
//
//	    // Filtro por hora de fin
//	    if (this.jornadaFinal != null) {
//	        predicates.add(criteriaBuilder.equal(root.get("jornadaFinal"), jornadaFinal));
//	    }
//
//	    // Combinar todos los predicados con AND
//	    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
//	}
}
