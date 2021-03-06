package com.setas.modelo;
// Generated 12-sep-2018 1:15:09 by Hibernate Tools 5.2.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Nombre generated by hbm2java
 */
@Entity
@Table(name = "nombre", catalog = "setasdb")
public class Nombre implements java.io.Serializable {

	private int idnombre;
	private Seta seta;
	private String nombre;
	private String idioma;

	public Nombre() {
	}

	public Nombre(int idnombre, Seta seta) {
		this.idnombre = idnombre;
		this.seta = seta;
	}

	public Nombre(int idnombre, Seta seta, String nombre, String idioma) {
		this.idnombre = idnombre;
		this.seta = seta;
		this.nombre = nombre;
		this.idioma = idioma;
	}

	@Id

	@Column(name = "idnombre", unique = true, nullable = false)
	public int getIdnombre() {
		return this.idnombre;
	}

	public void setIdnombre(int idnombre) {
		this.idnombre = idnombre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idseta", nullable = false)
	public Seta getSeta() {
		return this.seta;
	}

	public void setSeta(Seta seta) {
		this.seta = seta;
	}

	@Column(name = "nombre", length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "idioma", length = 2)
	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

}
