package com.setas.modelo;
// Generated 23-jul-2018 20:02:57 by Hibernate Tools 5.2.10.Final

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

/**
 * Subclase generated by hbm2java
 */
@Entity
@Table(name = "subclase", catalog = "setasdb")
public class Subclase implements java.io.Serializable {

	private Integer idsubclase;
	private Clase clase;
	private String subclase;
	private Set<Orden> ordens = new HashSet<Orden>(0);

	public Subclase() {
	}

	public Subclase(Clase clase, String subclase) {
		this.clase = clase;
		this.subclase = subclase;
	}

	public Subclase(Clase clase, String subclase, Set<Orden> ordens) {
		this.clase = clase;
		this.subclase = subclase;
		this.ordens = ordens;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idsubclase", unique = true, nullable = false)
	public Integer getIdsubclase() {
		return this.idsubclase;
	}

	public void setIdsubclase(Integer idsubclase) {
		this.idsubclase = idsubclase;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idclase", nullable = false)
	public Clase getClase() {
		return this.clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	@Column(name = "subclase", nullable = false, length = 25)
	public String getSubclase() {
		return this.subclase;
	}

	public void setSubclase(String subclase) {
		this.subclase = subclase;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subclase")
	public Set<Orden> getOrdens() {
		return this.ordens;
	}

	public void setOrdens(Set<Orden> ordens) {
		this.ordens = ordens;
	}

}
