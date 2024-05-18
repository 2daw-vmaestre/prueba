package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the consulta_cita database table.
 * 
 */
@Entity
@Table(name="consulta_cita")
@NamedQuery(name="ConsultaCita.findAll", query="SELECT c FROM ConsultaCita c")
public class ConsultaCita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private boolean especialista;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_fin")
	private Date horaFin;

	private String motivo;

	private String prescripcion;

	//bi-directional many-to-one association to Cita
	@ManyToOne
	@JoinColumn(name="id_cita")
	private Cita cita;

	public ConsultaCita() {
	}

	public Long getId() {
		return this.id;
	}


	public boolean getEspecialista() {
		return this.especialista;
	}

	public void setEspecialista(boolean especialista) {
		this.especialista = especialista;
	}

	public Date getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getPrescripcion() {
		return this.prescripcion;
	}

	public void setPrescripcion(String prescripcion) {
		this.prescripcion = prescripcion;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

}