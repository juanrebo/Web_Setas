package com.setas.accionUsuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.util.Accion;

public class CerrarUsuarioAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		
		if(request.getServletPath().contains("admin") || request.getServletPath().contains("user")) {
			return "REDIRECT ../Inicio.jsp";
		}else {
			return "Inicio.jsp";
		}
	}

}
