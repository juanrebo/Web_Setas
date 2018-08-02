package com.setas.modelo;
// Generated 02-ago-2018 19:14:14 by Hibernate Tools 5.2.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Foto generated by hbm2java
 */
@Entity
@Table(name = "foto", catalog = "setasdb")
public class Foto implements java.io.Serializable {

	private Integer idfoto;
	private Seta seta;
	private String ruta;

	public Foto() {
	}

	public Foto(Seta seta) {
		this.seta = seta;
	}

	public Foto(Seta seta, String ruta) {
		this.seta = seta;
		this.ruta = ruta;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idfoto", unique = true, nullable = false)
	public Integer getIdfoto() {
		return this.idfoto;
	}

	public void setIdfoto(Integer idfoto) {
		this.idfoto = idfoto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idseta", nullable = false)
	public Seta getSeta() {
		return this.seta;
	}

	public void setSeta(Seta seta) {
		this.seta = seta;
	}

	@Column(name = "ruta", length = 45)
	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}
