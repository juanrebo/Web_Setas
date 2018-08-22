package com.setas.modelo;
// Generated 22-ago-2018 11:06:04 by Hibernate Tools 5.2.10.Final

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
 * Clase generated by hbm2java
 */
@Entity
@Table(name = "clase", catalog = "setasdb", uniqueConstraints = @UniqueConstraint(columnNames = "clase"))
public class Clase implements java.io.Serializable {

	private Integer idclase;
	private Filo filo;
	private String clase;
	private Set<Orden> ordens = new HashSet<Orden>(0);

	public Clase() {
	}

	public Clase(Filo filo, String clase) {
		this.filo = filo;
		this.clase = clase;
	}

	public Clase(Filo filo, String clase, Set<Orden> ordens) {
		this.filo = filo;
		this.clase = clase;
		this.ordens = ordens;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idclase", unique = true, nullable = false)
	public Integer getIdclase() {
		return this.idclase;
	}

	public void setIdclase(Integer idclase) {
		this.idclase = idclase;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idfilo", nullable = false)
	public Filo getFilo() {
		return this.filo;
	}

	public void setFilo(Filo filo) {
		this.filo = filo;
	}

	@Column(name = "clase", unique = true, nullable = false, length = 25)
	public String getClase() {
		return this.clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clase")
	public Set<Orden> getOrdens() {
		return this.ordens;
	}

	public void setOrdens(Set<Orden> ordens) {
		this.ordens = ordens;
	}

}
