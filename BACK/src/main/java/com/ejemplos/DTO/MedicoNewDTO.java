package com.ejemplos.DTO;

import java.sql.Time;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
//
@Getter
@Setter
@Component
public class MedicoNewDTO { 
	
//	private long idCliente;
	private String nombre;
	private String apellidos;
	private Time jornadaFinal;
	private Time jornadaInicio;
	private String numeroIdentificacion;
	private String pass;

}
