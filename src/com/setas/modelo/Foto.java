package com.setas.modelo;
// Generated 22-ago-2018 10:04:30 by Hibernate Tools 5.3.0.Beta2

/**
 * Foto generated by hbm2java
 */
public class Foto implements java.io.Serializable {

	private Integer idfoto;
	private Seta seta;
	private String ruta;
	private String derecho;

	public Foto() {
	}

	public Foto(Seta seta, String ruta) {
		this.seta = seta;
		this.ruta = ruta;
	}

	public Foto(Seta seta, String ruta, String derecho) {
		this.seta = seta;
		this.ruta = ruta;
		this.derecho = derecho;
	}

	public Integer getIdfoto() {
		return this.idfoto;
	}

	public void setIdfoto(Integer idfoto) {
		this.idfoto = idfoto;
	}

	public Seta getSeta() {
		return this.seta;
	}

	public void setSeta(Seta seta) {
		this.seta = seta;
	}

	public String getRuta() {
		return this.ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getDerecho() {
		return this.derecho;
	}

	public void setDerecho(String derecho) {
		this.derecho = derecho;
	}

}
