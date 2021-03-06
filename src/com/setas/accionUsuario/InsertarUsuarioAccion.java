package com.setas.accionUsuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Lugar;
import com.setas.modelo.Usuario;
import com.setas.service.ServiceLugar;
import com.setas.service.ServiceLugarImp;
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
		try {
			su.insertarUsuario(usuario);
		}catch(Exception e) {
			request.setAttribute("error", e.getCause());
			return "Error.jsp";
		}
		
		Lugar lugar = new Lugar();
		lugar.setLugar("Sin lugar");
		lugar.setUsuario(usuario);
		ServiceLugar sl = new ServiceLugarImp();
		sl.insertarLugar(lugar);
		
		return "login.html";
	}

}
