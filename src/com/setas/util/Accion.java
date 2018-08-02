package com.setas.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.accionClasificacion.ClaseAccion;
import com.setas.accionClasificacion.EliminarClaseAccion;
import com.setas.accionClasificacion.EliminarFamiliaAccion;
import com.setas.accionClasificacion.EliminarFiloAccion;
import com.setas.accionClasificacion.EliminarGeneroAccion;
import com.setas.accionClasificacion.EliminarOrdenAccion;
import com.setas.accionClasificacion.FamiliaAccion;
import com.setas.accionClasificacion.FiloAccion;
import com.setas.accionClasificacion.GeneroAccion;
import com.setas.accionClasificacion.InsertarClaseAccion;
import com.setas.accionClasificacion.InsertarFamiliaAccion;
import com.setas.accionClasificacion.InsertarFiloAccion;
import com.setas.accionClasificacion.InsertarGeneroAccion;
import com.setas.accionClasificacion.InsertarOrdenAccion;
import com.setas.accionClasificacion.ModificarClaseAccion;
import com.setas.accionClasificacion.ModificarFamiliaAccion;
import com.setas.accionClasificacion.ModificarFiloAccion;
import com.setas.accionClasificacion.ModificarGeneroAccion;
import com.setas.accionClasificacion.ModificarOrdenAccion;
import com.setas.accionClasificacion.OrdenAccion;
import com.setas.accionUsuario.ComprobarUsuarioAccion;
import com.setas.accionUsuario.InsertarUsuarioAccion;

public abstract class Accion {
	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);
	
	public static Accion getAccion(String tipo) {
		Accion accion = null;
		
		if(tipo.equals("insertarUsuario")) {
			accion = new InsertarUsuarioAccion();
		}
		
		if(tipo.equals("iniciarSesion")) {
			accion = new ComprobarUsuarioAccion();
		}
		
		if(tipo.equals("filo")) {
			accion = new FiloAccion();
		}
		
		if(tipo.equals("eliminarFilo")) {
			accion = new EliminarFiloAccion();
		}
		
		if(tipo.equals("insertarFilo")) {
			accion = new InsertarFiloAccion();
		}
		
		if(tipo.equals("modificarFilo")) {
			accion = new ModificarFiloAccion();
		}
		
		if(tipo.equals("clase")) {
			accion = new ClaseAccion();
		}
		
		if(tipo.equals("eliminarClase")) {
			accion = new EliminarClaseAccion();
		}
		
		if(tipo.equals("insertarClase")) {
			accion = new InsertarClaseAccion();
		}
		
		if(tipo.equals("modificarClase")) {
			accion = new ModificarClaseAccion();
		}
		
		if(tipo.equals("orden")) {
			accion = new OrdenAccion();
		}
		
		if(tipo.equals("eliminarOrden")) {
			accion = new EliminarOrdenAccion();
		}
		
		if(tipo.equals("insertarOrden")) {
			accion = new InsertarOrdenAccion();
		}
		
		if(tipo.equals("modificarOrden")) {
			accion = new ModificarOrdenAccion();
		}
		
		if(tipo.equals("familia")) {
			accion = new FamiliaAccion();
		}
		
		if(tipo.equals("eliminarFamilia")) {
			accion = new EliminarFamiliaAccion();
		}
		
		if(tipo.equals("insertarFamilia")) {
			accion = new InsertarFamiliaAccion();
		}
		
		if(tipo.equals("modificarFamilia")) {
			accion = new ModificarFamiliaAccion();
		}
		
		if(tipo.equals("genero")) {
			accion = new GeneroAccion();
		}
		
		if(tipo.equals("eliminarGenero")) {
			accion = new EliminarGeneroAccion();
		}
		
		if(tipo.equals("insertarGenero")) {
			accion = new InsertarGeneroAccion();
		}
		
		if(tipo.equals("modificarGenero")) {
			accion = new ModificarGeneroAccion();
		}
		return accion;
	}
}
