package com.ejemplos.DTO;

import java.sql.Time;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.ejemplos.criteria.ObjectDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicoDTO implements ObjectDTO<MedicoDTO> { 
	
	private Long id;
	private String nombre;
	private String apellidos;
	private LocalTime jornadaInicio;
	private LocalTime jornadaFinal;
	private String numeroIdentificacion;
	private String pass;
	private String nuevaPass;
	private String validaciones;
	
	

}
