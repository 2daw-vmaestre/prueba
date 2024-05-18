package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the auditoria database table.
 * 
 */
@Entity
@NamedQuery(name="Auditoria.findAll", query="SELECT a FROM Auditoria a")
public class Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private boolean activa;

	private String descripcion;

	@Column(name="estado_auditoria")
	private String estadoAuditoria;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;

	@Column(name="id_auditor")
	private Long idAuditor;

	//bi-directional one-to-one association to AuditoriaPreguntaRespuesta
	@OneToOne(mappedBy="auditoria")
	private AuditoriaPreguntaRespuesta auditoriaPreguntaRespuesta;

	public Auditoria() {
	}

	public Long getId() {
		return this.id;
	}

	

	public boolean getActiva() {
		return this.activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstadoAuditoria() {
		return this.estadoAuditoria;
	}

	public void setEstadoAuditoria(String estadoAuditoria) {
		this.estadoAuditoria = estadoAuditoria;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Long getIdAuditor() {
		return this.idAuditor;
	}

	public void setIdAuditor(Long idAuditor) {
		this.idAuditor = idAuditor;
	}

	public AuditoriaPreguntaRespuesta getAuditoriaPreguntaRespuesta() {
		return this.auditoriaPreguntaRespuesta;
	}

	public void setAuditoriaPreguntaRespuesta(AuditoriaPreguntaRespuesta auditoriaPreguntaRespuesta) {
		this.auditoriaPreguntaRespuesta = auditoriaPreguntaRespuesta;
	}

}