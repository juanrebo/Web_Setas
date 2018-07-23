package com.setas.modelo;
// Generated 21-jul-2018 11:03:29 by Hibernate Tools 5.3.0.Beta2

/**
 * Localizacion generated by hbm2java
 */
public class Localizacion implements java.io.Serializable {

	private Integer idlocalizacion;
	private Coleccion coleccion;
	private Lugar lugar;
	private String coordenadas;

	public Localizacion() {
	}

	public Localizacion(Coleccion coleccion, Lugar lugar, String coordenadas) {
		this.coleccion = coleccion;
		this.lugar = lugar;
		this.coordenadas = coordenadas;
	}

	public Integer getIdlocalizacion() {
		return this.idlocalizacion;
	}

	public void setIdlocalizacion(Integer idlocalizacion) {
		this.idlocalizacion = idlocalizacion;
	}

	public Coleccion getColeccion() {
		return this.coleccion;
	}

	public void setColeccion(Coleccion coleccion) {
		this.coleccion = coleccion;
	}

	public Lugar getLugar() {
		return this.lugar;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public String getCoordenadas() {
		return this.coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

}
