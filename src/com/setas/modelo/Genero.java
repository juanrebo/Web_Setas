package com.setas.modelo;
// Generated 22-ago-2018 17:30:24 by Hibernate Tools 5.2.10.Final

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
 * Genero generated by hbm2java
 */
@Entity
@Table(name = "genero", catalog = "setasdb", uniqueConstraints = @UniqueConstraint(columnNames = "genero"))
public class Genero implements java.io.Serializable {

	private Integer idgenero;
	private Familia familia;
	private String genero;
	private Set<Seta> setas = new HashSet<Seta>(0);

	public Genero() {
	}

	public Genero(Familia familia, String genero) {
		this.familia = familia;
		this.genero = genero;
	}

	public Genero(Familia familia, String genero, Set<Seta> setas) {
		this.familia = familia;
		this.genero = genero;
		this.setas = setas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idgenero", unique = true, nullable = false)
	public Integer getIdgenero() {
		return this.idgenero;
	}

	public void setIdgenero(Integer idgenero) {
		this.idgenero = idgenero;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idfamilia", nullable = false)
	public Familia getFamilia() {
		return this.familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	@Column(name = "genero", unique = true, nullable = false, length = 25)
	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "genero")
	public Set<Seta> getSetas() {
		return this.setas;
	}

	public void setSetas(Set<Seta> setas) {
		this.setas = setas;
	}

}
