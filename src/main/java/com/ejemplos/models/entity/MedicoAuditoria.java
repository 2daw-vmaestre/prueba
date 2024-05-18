package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the medico_auditoria database table.
 * 
 */
@Entity
@Table(name="medico_auditoria")
@NamedQuery(name="MedicoAuditoria.findAll", query="SELECT m FROM MedicoAuditoria m")
public class MedicoAuditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_auditoria")
	private Date fechaAuditoria;

	//bi-directional many-to-one association to Auditoria
	@ManyToOne
	@JoinColumn(name="id_auditoria")
	private Auditoria auditoria;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(name="id_medico")
	private Medico medico;

	public MedicoAuditoria() {
	}

	public Long getId() {
		return this.id;
	}



	public Date getFechaAuditoria() {
		return this.fechaAuditoria;
	}

	public void setFechaAuditoria(Date fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	public Auditoria getAuditoria() {
		return this.auditoria;
	}

	public void setAuditoria(Auditoria auditoria) {
		this.auditoria = auditoria;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

}