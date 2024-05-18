package com.ejemplos.models.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the administrador database table.
 * 
 */
@Entity
@Table(name="administrador")
@NamedQuery(name="Administrador.findAll", query="SELECT a FROM Administrador a")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String pass;

	private String usuario;

//	//bi-directional many-to-one association to Auditoria
//	@OneToMany(mappedBy="administrador")
//	private List<Auditoria> auditorias;

	public Administrador() {
	}

	public Long getId() {
		return this.id;
	}

	

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

//	public List<Auditoria> getAuditorias() {
//		return this.auditorias;
//	}
//
//	public void setAuditorias(List<Auditoria> auditorias) {
//		this.auditorias = auditorias;
//	}

//	public Auditoria addAuditoria(Auditoria auditoria) {
//		getAuditorias().add(auditoria);
//		auditoria.setAdministrador(this);
//
//		return auditoria;
//	}
//
//	public Auditoria removeAuditoria(Auditoria auditoria) {
//		getAuditorias().remove(auditoria);
//		auditoria.setAdministrador(null);
//
//		return auditoria;
//	}

}