package com.setas.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.accionClasificacion.DivisionAccion;
import com.setas.accionClasificacion.EliminarDivisionAccion;
import com.setas.accionClasificacion.EliminarSubdivisionAccion;
import com.setas.accionClasificacion.InsertarDivisionAccion;
import com.setas.accionClasificacion.InsertarSubdivisionAccion;
import com.setas.accionClasificacion.SubdivisionAccion;
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
		
		if(tipo.equals("division")) {
			accion = new DivisionAccion();
		}
		
		if(tipo.equals("eliminarDivision")) {
			accion = new EliminarDivisionAccion();
		}
		
		if(tipo.equals("insertarDivision")) {
			accion = new InsertarDivisionAccion();
		}
		
		if(tipo.equals("subdivision")) {
			accion = new SubdivisionAccion();
		}
		
		if(tipo.equals("eliminarSubdivision")) {
			accion = new EliminarSubdivisionAccion();
		}
		
		if(tipo.equals("insertarSubdivision")) {
			accion = new InsertarSubdivisionAccion();
		}
		return accion;
	}
}
