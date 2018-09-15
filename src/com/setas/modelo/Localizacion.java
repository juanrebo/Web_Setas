package com.setas.modelo;
// Generated 12-sep-2018 1:15:09 by Hibernate Tools 5.2.10.Final

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
 * Localizacion generated by hbm2java
 */
@Entity
@Table(name = "localizacion", catalog = "setasdb")
public class Localizacion implements java.io.Serializable {

	private Integer idlocalizacion;
	private Lugar lugar;
	private Seta seta;
	private Usuario usuario;
	private String latitud;
	private String longitud;

	public Localizacion() {
	}

	public Localizacion(Seta seta, Usuario usuario, String latitud, String longitud) {
		this.seta = seta;
		this.usuario = usuario;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Localizacion(Lugar lugar, Seta seta, Usuario usuario, String latitud, String longitud) {
		this.lugar = lugar;
		this.seta = seta;
		this.usuario = usuario;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idlocalizacion", unique = true, nullable = false)
	public Integer getIdlocalizacion() {
		return this.idlocalizacion;
	}

	public void setIdlocalizacion(Integer idlocalizacion) {
		this.idlocalizacion = idlocalizacion;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idlugar")
	public Lugar getLugar() {
		return this.lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idseta", nullable = false)
	public Seta getSeta() {
		return this.seta;
	}

	public void setSeta(Seta seta) {
		this.seta = seta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "latitud", nullable = false, length = 25)
	public String getLatitud() {
		return this.latitud;
	}

	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	@Column(name = "longitud", nullable = false, length = 25)
	public String getLongitud() {
		return this.longitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

}
