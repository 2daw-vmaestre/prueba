package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the respuesta database table.
 * 
 */
@Entity
@NamedQuery(name="Respuesta.findAll", query="SELECT r FROM Respuesta r")
public class Respuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private byte activa;

	private String descripcion;

	@Column(name="respuesta_correcta")
	private byte respuestaCorrecta;

	//bi-directional many-to-one association to AuditoriaPreguntaRespuesta
	@OneToMany(mappedBy="respuesta")
	private List<AuditoriaPreguntaRespuesta> auditoriaPreguntaRespuestas;

	//bi-directional many-to-one association to RespuestaMedico
	@OneToMany(mappedBy="respuesta")
	private List<RespuestaMedico> respuestaMedicos;

	public Respuesta() {
	}

	public Long getId() {
		return this.id;
	}

	

	public byte getActiva() {
		return this.activa;
	}

	public void setActiva(byte activa) {
		this.activa = activa;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public byte getRespuestaCorrecta() {
		return this.respuestaCorrecta;
	}

	public void setRespuestaCorrecta(byte respuestaCorrecta) {
		this.respuestaCorrecta = respuestaCorrecta;
	}

	public List<AuditoriaPreguntaRespuesta> getAuditoriaPreguntaRespuestas() {
		return this.auditoriaPreguntaRespuestas;
	}

	public void setAuditoriaPreguntaRespuestas(List<AuditoriaPreguntaRespuesta> auditoriaPreguntaRespuestas) {
		this.auditoriaPreguntaRespuestas = auditoriaPreguntaRespuestas;
	}

	public AuditoriaPreguntaRespuesta addAuditoriaPreguntaRespuesta(AuditoriaPreguntaRespuesta auditoriaPreguntaRespuesta) {
		getAuditoriaPreguntaRespuestas().add(auditoriaPreguntaRespuesta);
		auditoriaPreguntaRespuesta.setRespuesta(this);

		return auditoriaPreguntaRespuesta;
	}

	public AuditoriaPreguntaRespuesta removeAuditoriaPreguntaRespuesta(AuditoriaPreguntaRespuesta auditoriaPreguntaRespuesta) {
		getAuditoriaPreguntaRespuestas().remove(auditoriaPreguntaRespuesta);
		auditoriaPreguntaRespuesta.setRespuesta(null);

		return auditoriaPreguntaRespuesta;
	}

	public List<RespuestaMedico> getRespuestaMedicos() {
		return this.respuestaMedicos;
	}

	public void setRespuestaMedicos(List<RespuestaMedico> respuestaMedicos) {
		this.respuestaMedicos = respuestaMedicos;
	}

	public RespuestaMedico addRespuestaMedico(RespuestaMedico respuestaMedico) {
		getRespuestaMedicos().add(respuestaMedico);
		respuestaMedico.setRespuesta(this);

		return respuestaMedico;
	}

	public RespuestaMedico removeRespuestaMedico(RespuestaMedico respuestaMedico) {
		getRespuestaMedicos().remove(respuestaMedico);
		respuestaMedico.setRespuesta(null);

		return respuestaMedico;
	}

}