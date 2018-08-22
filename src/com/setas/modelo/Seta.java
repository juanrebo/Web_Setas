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

/**
 * Seta generated by hbm2java
 */
@Entity
@Table(name = "seta", catalog = "setasdb")
public class Seta implements java.io.Serializable {

	private Integer idseta;
	private Genero genero;
	private String especie;
	private String cuerpoFructifero;
	private String sombrero;
	private String himenio;
	private String laminas;
	private String tubos;
	private String gleba;
	private String estroma;
	private String pie;
	private String carne;
	private String esporas;
	private String habitat;
	private String comestibilidad;
	private Set<Localizacion> localizacions = new HashSet<Localizacion>(0);
	private Set<Coleccion> coleccions = new HashSet<Coleccion>(0);
	private Set<Foto> fotos = new HashSet<Foto>(0);

	public Seta() {
	}

	public Seta(Genero genero, String especie) {
		this.genero = genero;
		this.especie = especie;
	}

	public Seta(Genero genero, String especie, String cuerpoFructifero, String sombrero, String himenio, String laminas,
			String tubos, String gleba, String estroma, String pie, String carne, String esporas, String habitat,
			String comestibilidad, Set<Localizacion> localizacions, Set<Coleccion> coleccions, Set<Foto> fotos) {
		this.genero = genero;
		this.especie = especie;
		this.cuerpoFructifero = cuerpoFructifero;
		this.sombrero = sombrero;
		this.himenio = himenio;
		this.laminas = laminas;
		this.tubos = tubos;
		this.gleba = gleba;
		this.estroma = estroma;
		this.pie = pie;
		this.carne = carne;
		this.esporas = esporas;
		this.habitat = habitat;
		this.comestibilidad = comestibilidad;
		this.localizacions = localizacions;
		this.coleccions = coleccions;
		this.fotos = fotos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idseta", unique = true, nullable = false)
	public Integer getIdseta() {
		return this.idseta;
	}

	public void setIdseta(Integer idseta) {
		this.idseta = idseta;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idgenero", nullable = false)
	public Genero getGenero() {
		return this.genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Column(name = "especie", nullable = false, length = 20)
	public String getEspecie() {
		return this.especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	@Column(name = "cuerpoFructifero", length = 500)
	public String getCuerpoFructifero() {
		return this.cuerpoFructifero;
	}

	public void setCuerpoFructifero(String cuerpoFructifero) {
		this.cuerpoFructifero = cuerpoFructifero;
	}

	@Column(name = "sombrero", length = 500)
	public String getSombrero() {
		return this.sombrero;
	}

	public void setSombrero(String sombrero) {
		this.sombrero = sombrero;
	}

	@Column(name = "himenio", length = 500)
	public String getHimenio() {
		return this.himenio;
	}

	public void setHimenio(String himenio) {
		this.himenio = himenio;
	}

	@Column(name = "laminas", length = 500)
	public String getLaminas() {
		return this.laminas;
	}

	public void setLaminas(String laminas) {
		this.laminas = laminas;
	}

	@Column(name = "tubos", length = 500)
	public String getTubos() {
		return this.tubos;
	}

	public void setTubos(String tubos) {
		this.tubos = tubos;
	}

	@Column(name = "gleba", length = 500)
	public String getGleba() {
		return this.gleba;
	}

	public void setGleba(String gleba) {
		this.gleba = gleba;
	}

	@Column(name = "estroma", length = 500)
	public String getEstroma() {
		return this.estroma;
	}

	public void setEstroma(String estroma) {
		this.estroma = estroma;
	}

	@Column(name = "pie", length = 500)
	public String getPie() {
		return this.pie;
	}

	public void setPie(String pie) {
		this.pie = pie;
	}

	@Column(name = "carne", length = 500)
	public String getCarne() {
		return this.carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	@Column(name = "esporas", length = 500)
	public String getEsporas() {
		return this.esporas;
	}

	public void setEsporas(String esporas) {
		this.esporas = esporas;
	}

	@Column(name = "habitat", length = 500)
	public String getHabitat() {
		return this.habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	@Column(name = "comestibilidad", length = 500)
	public String getComestibilidad() {
		return this.comestibilidad;
	}

	public void setComestibilidad(String comestibilidad) {
		this.comestibilidad = comestibilidad;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seta")
	public Set<Localizacion> getLocalizacions() {
		return this.localizacions;
	}

	public void setLocalizacions(Set<Localizacion> localizacions) {
		this.localizacions = localizacions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seta")
	public Set<Coleccion> getColeccions() {
		return this.coleccions;
	}

	public void setColeccions(Set<Coleccion> coleccions) {
		this.coleccions = coleccions;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "seta")
	public Set<Foto> getFotos() {
		return this.fotos;
	}

	public void setFotos(Set<Foto> fotos) {
		this.fotos = fotos;
	}

}
