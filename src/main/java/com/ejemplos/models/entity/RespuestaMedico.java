package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the respuesta_medico database table.
 * 
 */
@Entity
@Table(name="respuesta_medico")
@NamedQuery(name="RespuestaMedico.findAll", query="SELECT r FROM RespuestaMedico r")
public class RespuestaMedico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	//bi-directional many-to-one association to Pregunta
	@ManyToOne
	@JoinColumn(name="id_pregunta")
	private Pregunta pregunta;

	//bi-directional many-to-one association to Respuesta
	@ManyToOne
	@JoinColumn(name="id_respuesta_seleccionada")
	private Respuesta respuesta;

	public RespuestaMedico() {
	}

	public Long getId() {
		return this.id;
	}

	

	public Pregunta getPregunta() {
		return this.pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Respuesta getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

}