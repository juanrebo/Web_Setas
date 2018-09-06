package com.setas.accionUsuario;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Usuario;
import com.setas.service.ServiceFavorito;
import com.setas.service.ServiceFavoritoImp;
import com.setas.service.ServiceLocalizacion;
import com.setas.service.ServiceLocalizacionImp;
import com.setas.service.ServiceLugar;
import com.setas.service.ServiceLugarImp;
import com.setas.service.ServiceUsuario;
import com.setas.service.ServiceUsuarioImp;
import com.setas.util.Accion;

public class ComprobarUsuarioAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String respuesta = "";
		ServiceUsuario su = new ServiceUsuarioImp();
		Usuario usuario = null;

		try{
			usuario = su.obtenerUsuario(request.getParameter("nombre"));
		}catch(NoResultException e) {
			respuesta = "login.html";
		}

		if (usuario.getContrasena().equals(request.getParameter("contrasena"))){
			request.getSession().setAttribute("usuario", usuario);
			request.getSession().setAttribute("rol", usuario.getRol());
			
			ServiceLocalizacion sl = new ServiceLocalizacionImp();
			request.getSession().setAttribute("listaLocalizacion", sl.recuperarLocalizaUsu(usuario));
			
			ServiceFavorito sf = new ServiceFavoritoImp();
			request.getSession().setAttribute("listaFavorito", sf.recuperaFavoritos(usuario));
			
			ServiceLugar sg = new ServiceLugarImp();
			request.getSession().setAttribute("listaLugar", sg.recuperaLugares(usuario));
			
			respuesta = "Inicio.jsp";
		}else {
			respuesta = "login.html";
		}

		return respuesta;
	}

}
