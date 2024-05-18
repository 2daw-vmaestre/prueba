package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cita database table.
 * 
 */
@Entity
@Data
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	@Column(name="estado_cita")
	private String estadoCita;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="hora_inicio")
	private Date horaInicio;

	@Column(name="tipo_cita")
	private String tipoCita;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(name="id_medico")
	private Medico medico;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="id_paciente")
	private Paciente paciente;

	//bi-directional many-to-one association to ConsultaCita
	@OneToMany(mappedBy="cita")
	private List<ConsultaCita> consultaCitas;

	//bi-directional many-to-one association to Documentacion
	@OneToMany(mappedBy="cita")
	private List<Documentacion> documentacions;

	public Cita() {
	}

	public Long getId() {
		return this.id;
	}



	public String getEstadoCita() {
		return this.estadoCita;
	}

	public void setEstadoCita(String estadoCita) {
		this.estadoCita = estadoCita;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getTipoCita() {
		return this.tipoCita;
	}

	public void setTipoCita(String tipoCita) {
		this.tipoCita = tipoCita;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<ConsultaCita> getConsultaCitas() {
		return this.consultaCitas;
	}

	public void setConsultaCitas(List<ConsultaCita> consultaCitas) {
		this.consultaCitas = consultaCitas;
	}

	public ConsultaCita addConsultaCita(ConsultaCita consultaCita) {
		getConsultaCitas().add(consultaCita);
		consultaCita.setCita(this);

		return consultaCita;
	}

	public ConsultaCita removeConsultaCita(ConsultaCita consultaCita) {
		getConsultaCitas().remove(consultaCita);
		consultaCita.setCita(null);

		return consultaCita;
	}

	public List<Documentacion> getDocumentacions() {
		return this.documentacions;
	}

	public void setDocumentacions(List<Documentacion> documentacions) {
		this.documentacions = documentacions;
	}

	public Documentacion addDocumentacion(Documentacion documentacion) {
		getDocumentacions().add(documentacion);
		documentacion.setCita(this);

		return documentacion;
	}

	public Documentacion removeDocumentacion(Documentacion documentacion) {
		getDocumentacions().remove(documentacion);
		documentacion.setCita(null);

		return documentacion;
	}

}