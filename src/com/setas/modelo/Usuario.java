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
 * Usuario generated by hbm2java
 */
@Entity
@Table(name = "usuario", catalog = "setasdb", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario implements java.io.Serializable {

	private Integer idusuario;
	private Rol rol;
	private String nombre;
	private String contrasena;
	private String email;
	private Set<Localizacion> localizacions = new HashSet<Localizacion>(0);
	private Set<Lugar> lugars = new HashSet<Lugar>(0);
	private Set<Favorito> favoritos = new HashSet<Favorito>(0);

	public Usuario() {
	}

	public Usuario(Rol rol, String nombre, String contrasena, String email) {
		this.rol = rol;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.email = email;
	}

	public Usuario(Rol rol, String nombre, String contrasena, String email, Set<Localizacion> localizacions,
			Set<Lugar> lugars, Set<Favorito> favoritos) {
		this.rol = rol;
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.email = email;
		this.localizacions = localizacions;
		this.lugars = lugars;
		this.favoritos = favoritos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idusuario", unique = true, nullable = false)
	public Integer getIdusuario() {
		return this.idusuario;
	}

	public void setIdusuario(Integer idusuario) {
		
		this.idusuario = idusuario;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idrol", nullable = false)
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Column(name = "nombre", unique = true, nullable = false, length = 20)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "contrasena", nullable = false, length = 20)
	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Column(name = "email", unique = true, nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Localizacion> getLocalizacions() {
		return this.localizacions;
	}

	public void setLocalizacions(Set<Localizacion> localizacions) {
		this.localizacions = localizacions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Lugar> getLugars() {
		return this.lugars;
	}

	public void setLugars(Set<Lugar> lugars) {
		this.lugars = lugars;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Favorito> getFavoritos() {
		return this.favoritos;
	}

	public void setFavoritos(Set<Favorito> favoritos) {
		this.favoritos = favoritos;
	}

}
