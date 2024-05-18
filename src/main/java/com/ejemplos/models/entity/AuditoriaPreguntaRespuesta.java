package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the auditoria_pregunta_respuesta database table.
 * 
 */
@Entity
@Table(name="auditoria_pregunta_respuesta")
@NamedQuery(name="AuditoriaPreguntaRespuesta.findAll", query="SELECT a FROM AuditoriaPreguntaRespuesta a")
public class AuditoriaPreguntaRespuesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="id_auditoria")
	private Long idAuditoria;

	//bi-directional one-to-one association to Auditoria
	@OneToOne
	@JoinColumn(name="id")
	private Auditoria auditoria;

	//bi-directional many-to-one association to Pregunta
	@ManyToOne
	@JoinColumn(name="id_pregunta")
	private Pregunta pregunta;

	//bi-directional many-to-one association to Respuesta
	@ManyToOne
	@JoinColumn(name="id_respuesta")
	private Respuesta respuesta;

	public AuditoriaPreguntaRespuesta() {
	}

	public Long getId() {
		return this.id;
	}


	public Long getIdAuditoria() {
		return this.idAuditoria;
	}

	public void setIdAuditoria(Long idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public Auditoria getAuditoria() {
		return this.auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
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