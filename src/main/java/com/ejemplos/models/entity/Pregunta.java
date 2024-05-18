package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pregunta database table.
 * 
 */
@Entity
@NamedQuery(name="Pregunta.findAll", query="SELECT p FROM Pregunta p")
public class Pregunta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private byte activa;

	private String descripcion;

	//bi-directional many-to-one association to AuditoriaPreguntaRespuesta
	@OneToMany(mappedBy="pregunta")
	private List<AuditoriaPreguntaRespuesta> auditoriaPreguntaRespuestas;

	//bi-directional many-to-one association to RespuestaMedico
	@OneToMany(mappedBy="pregunta")
	private List<RespuestaMedico> respuestaMedicos;

	public Pregunta() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<AuditoriaPreguntaRespuesta> getAuditoriaPreguntaRespuestas() {
		return this.auditoriaPreguntaRespuestas;
	}

	public void setAuditoriaPreguntaRespuestas(List<AuditoriaPreguntaRespuesta> auditoriaPreguntaRespuestas) {
		this.auditoriaPreguntaRespuestas = auditoriaPreguntaRespuestas;
	}

	public AuditoriaPreguntaRespuesta addAuditoriaPreguntaRespuesta(AuditoriaPreguntaRespuesta auditoriaPreguntaRespuesta) {
		getAuditoriaPreguntaRespuestas().add(auditoriaPreguntaRespuesta);
		auditoriaPreguntaRespuesta.setPregunta(this);

		return auditoriaPreguntaRespuesta;
	}

	public AuditoriaPreguntaRespuesta removeAuditoriaPreguntaRespuesta(AuditoriaPreguntaRespuesta auditoriaPreguntaRespuesta) {
		getAuditoriaPreguntaRespuestas().remove(auditoriaPreguntaRespuesta);
		auditoriaPreguntaRespuesta.setPregunta(null);

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
		respuestaMedico.setPregunta(this);

		return respuestaMedico;
	}

	public RespuestaMedico removeRespuestaMedico(RespuestaMedico respuestaMedico) {
		getRespuestaMedicos().remove(respuestaMedico);
		respuestaMedico.setPregunta(null);

		return respuestaMedico;
	}

}