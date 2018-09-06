package com.setas.modelo;
// Generated 05-sep-2018 0:51:29 by Hibernate Tools 5.2.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Filo generated by hbm2java
 */
@Entity
@Table(name = "filo", catalog = "setasdb", uniqueConstraints = @UniqueConstraint(columnNames = "filo"))
public class Filo implements java.io.Serializable {

	private Integer idfilo;
	private String filo;
	private Set<Clase> clases = new HashSet<Clase>(0);

	public Filo() {
	}

	public Filo(String filo) {
		this.filo = filo;
	}

	public Filo(String filo, Set<Clase> clases) {
		this.filo = filo;
		this.clases = clases;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idfilo", unique = true, nullable = false)
	public Integer getIdfilo() {
		return this.idfilo;
	}

	public void setIdfilo(Integer idfilo) {
		this.idfilo = idfilo;
	}

	@Column(name = "filo", unique = true, nullable = false, length = 25)
	public String getFilo() {
		return this.filo;
	}

	public void setFilo(String filo) {
		this.filo = filo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "filo")
	public Set<Clase> getClases() {
		return this.clases;
	}

	public void setClases(Set<Clase> clases) {
		this.clases = clases;
	}

}
