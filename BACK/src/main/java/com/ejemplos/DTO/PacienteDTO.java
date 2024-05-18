package com.ejemplos.DTO;

import java.sql.Time;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PacienteDTO { 
	
	private Long id;
	private String nombre;
	private String apellidos;
	private Time jornadaInicio;
	private Time jornadaFinal;
	private String numeroIdentificacion;
	private String pass;
	private String nuevaPass;
	private String validaciones;
	
	

}
