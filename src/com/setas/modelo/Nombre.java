package com.setas.modelo;
// Generated 05-sep-2018 0:51:29 by Hibernate Tools 5.2.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Nombre generated by hbm2java
 */
@Entity
@Table(name = "nombre", catalog = "setasdb")
public class Nombre implements java.io.Serializable {

	private Integer idnombre;
	private Seta seta;
	private String nombre;
	private String idioma;

	public Nombre() {
	}

	public Nombre(Seta seta) {
		this.seta = seta;
	}

	public Nombre(Seta seta, String nombre, String idioma) {
		this.seta = seta;
		this.nombre = nombre;
		this.idioma = idioma;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idnombre", unique = true, nullable = false)
	public Integer getIdnombre() {
		return this.idnombre;
	}

	public void setIdnombre(Integer idnombre) {
		this.idnombre = idnombre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "idgenero", referencedColumnName = "idgenero", nullable = false),
			@JoinColumn(name = "especie", referencedColumnName = "especie", nullable = false) })
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