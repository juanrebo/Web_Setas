package com.setas.accionUsuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Rol;
import com.setas.modelo.Usuario;
import com.setas.service.ServiceUsuario;
import com.setas.service.ServiceUsuarioImp;
import com.setas.util.Accion;

public class ComprobarUsuarioAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String respuesta = "";
		ServiceUsuario su = new ServiceUsuarioImp();
		Usuario usuario = su.obtenerUsuario(request.getParameter("nombre"));
		
		if(usuario == null) {
			respuesta = "login.html";
		}else {
			if (usuario.getContrasena().equals(request.getParameter("contrasena"))){
				request.getSession().setAttribute("nombre", usuario.getNombre());
				request.getSession().setAttribute("rol", usuario.getRol().getRol());
				respuesta = "Inicio.html";
			}else {
				respuesta = "login.html";
			}
		}
		return respuesta;
	}

}
