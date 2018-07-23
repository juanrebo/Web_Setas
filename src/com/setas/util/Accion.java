package com.setas.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Accion {
	public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);
	
	public static Accion getAccion(String tipo) {
		Accion accion = null;
		
		
		
		return accion;
	}
}
