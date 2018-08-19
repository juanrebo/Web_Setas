package com.setas.accionUsuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.util.Accion;

public class CerrarUsuarioAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		return "Inicio.jsp";
	}

}
