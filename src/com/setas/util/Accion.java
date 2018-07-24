package com.setas.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		return accion;
	}
}
