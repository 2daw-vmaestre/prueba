package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the documentacion database table.
 * 
 */
@Entity
@NamedQuery(name="Documentacion.findAll", query="SELECT d FROM Documentacion d")
public class Documentacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String descripcion;

	private String documento;

	//bi-directional many-to-one association to Cita
	@ManyToOne
	@JoinColumn(name="id_cita")
	private Cita cita;

	public Documentacion() {
	}

	public Long getId() {
		return this.id;
	}


	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Cita getCita() {
		return this.cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

}