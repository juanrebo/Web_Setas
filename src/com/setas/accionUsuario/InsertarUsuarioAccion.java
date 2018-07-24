package com.setas.accionUsuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Usuario;
import com.setas.service.ServiceRol;
import com.setas.service.ServiceRolImp;
import com.setas.service.ServiceUsuario;
import com.setas.service.ServiceUsuarioImp;
import com.setas.util.Accion;

public class InsertarUsuarioAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario = new Usuario();
		usuario.setNombre(request.getParameter("nombre"));
		usuario.setContrasena(request.getParameter("contrasena"));
		usuario.setEmail(request.getParameter("correo"));
		ServiceRol rol = new ServiceRolImp();
		usuario.setRol(rol.getRol(2));
		
		ServiceUsuario su = new ServiceUsuarioImp();
		su.insertarUsuario(usuario);
		return "login.html";
	}

}
