package com.setas.modelo;
// Generated 12-sep-2018 1:15:09 by Hibernate Tools 5.2.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Familia generated by hbm2java
 */
@Entity
@Table(name = "familia", catalog = "setasdb", uniqueConstraints = @UniqueConstraint(columnNames = "familia"))
public class Familia implements java.io.Serializable {

	private Integer idfamilia;
	private Orden orden;
	private String familia;
	private Set<Genero> generos = new HashSet<Genero>(0);

	public Familia() {
	}

	public Familia(Orden orden, String familia) {
		this.orden = orden;
		this.familia = familia;
	}

	public Familia(Orden orden, String familia, Set<Genero> generos) {
		this.orden = orden;
		this.familia = familia;
		this.generos = generos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idfamilia", unique = true, nullable = false)
	public Integer getIdfamilia() {
		return this.idfamilia;
	}

	public void setIdfamilia(Integer idfamilia) {
		this.idfamilia = idfamilia;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idorden", nullable = false)
	public Orden getOrden() {
		return this.orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	@Column(name = "familia", unique = true, nullable = false, length = 25)
	public String getFamilia() {
		return this.familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "familia")
	public Set<Genero> getGeneros() {
		return this.generos;
	}

	public void setGeneros(Set<Genero> generos) {
		this.generos = generos;
	}

}
