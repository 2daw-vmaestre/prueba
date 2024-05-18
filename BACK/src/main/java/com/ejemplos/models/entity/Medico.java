package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.ejemplos.DTO.MedicoDTO;

import lombok.Data;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;


/**
 * The persistent class for the medico database table.
 * 
 */
@Entity
@Data
@NamedQuery(name="Medico.findAll", query="SELECT m FROM Medico m")
public class Medico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;

	@Column(name="apellidos")
	private String apellidos;

	@Column(name="jornada_final")
	private LocalTime jornadaFinal;

	@Column(name="jornada_inicio")
	private LocalTime jornadaInicio;

	@Column(name="nombre")
	private String nombre;

	@Column(name="numero_identificacion")
	private String numeroIdentificacion;

	@Column(name="pass")
	private String pass;
	
	@Column(name="activo")
	private boolean activo;

//	//bi-directional many-to-one association to Cita
//	@OneToMany(mappedBy="medico")
//	private List<Cita> citas;
//
//	//bi-directional many-to-one association to MedicoAuditoria
//	@OneToMany(mappedBy="medico")
//	private List<MedicoAuditoria> medicoAuditorias;
//
//	//bi-directional many-to-one association to Paciente
//	@OneToMany(mappedBy="medico")
//	private List<Paciente> pacientes;

	public Medico() {
	}

	public Long getId() {
		return this.id;
	}

	
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalTime getJornadaFinal() {
		return this.jornadaFinal;
	}

	public void setJornadaFinal(LocalTime jornadaFinal) {
		this.jornadaFinal = jornadaFinal;
	}

	public LocalTime getJornadaInicio() {
		return this.jornadaInicio;
	}

	public void setJornadaInicio(LocalTime jornadaInicio) {
		this.jornadaInicio = jornadaInicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}

	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

//	public List<Cita> getCitas() {
//		return this.citas;
//	}
//
//	public void setCitas(List<Cita> citas) {
//		this.citas = citas;
//	}

//	public Cita addCita(Cita cita) {
//		getCitas().add(cita);
//		cita.setMedico(this);
//
//		return cita;
//	}
//
//	public Cita removeCita(Cita cita) {
//		getCitas().remove(cita);
//		cita.setMedico(null);
//
//		return cita;
//	}

//	public List<MedicoAuditoria> getMedicoAuditorias() {
//		return this.medicoAuditorias;
//	}
//
//	public void setMedicoAuditorias(List<MedicoAuditoria> medicoAuditorias) {
//		this.medicoAuditorias = medicoAuditorias;
//	}

//	public MedicoAuditoria addMedicoAuditoria(MedicoAuditoria medicoAuditoria) {
//		getMedicoAuditorias().add(medicoAuditoria);
//		medicoAuditoria.setMedico(this);
//
//		return medicoAuditoria;
//	}
//
//	public MedicoAuditoria removeMedicoAuditoria(MedicoAuditoria medicoAuditoria) {
//		getMedicoAuditorias().remove(medicoAuditoria);
//		medicoAuditoria.setMedico(null);
//
//		return medicoAuditoria;
//	}

//	public List<Paciente> getPacientes() {
//		return this.pacientes;
//	}
//
//	public void setPacientes(List<Paciente> pacientes) {
//		this.pacientes = pacientes;
//	}

//	public Paciente addPaciente(Paciente paciente) {
//		getPacientes().add(paciente);
//		paciente.setMedico(this);
//
//		return paciente;
//	}
//
//	public Paciente removePaciente(Paciente paciente) {
//		getPacientes().remove(paciente);
//		paciente.setMedico(null);
//
//		return paciente;
//	}

	public void setActivo(boolean activo) {
		this.activo=activo;
		
	}

//	@Override
//	public String toString() {
//		return "Medico [id=" + id + ", apellidos=" + apellidos + ", jornadaFinal=" + jornadaFinal + ", jornadaInicio="
//				+ jornadaInicio + ", nombre=" + nombre + ", numeroIdentificacion=" + numeroIdentificacion + ", pass="
//				+ pass + ", activo=" + activo + ", citas=" + citas + ", medicoAuditorias=" + medicoAuditorias
//				+ ", pacientes=" + pacientes + "]";
//	}
	
	public MedicoDTO obtainDTObjectInfoSearch() {
		MedicoDTO dto = new MedicoDTO();
		dto.setNombre(this.getNombre());
		dto.setId(this.getId());
		return dto;
	}
	
	

}