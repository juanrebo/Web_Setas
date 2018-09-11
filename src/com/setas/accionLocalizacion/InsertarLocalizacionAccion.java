package com.setas.accionLocalizacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Genero;
import com.setas.modelo.Localizacion;
import com.setas.modelo.Lugar;
import com.setas.modelo.Seta;
import com.setas.modelo.Usuario;
import com.setas.service.ServiceGenero;
import com.setas.service.ServiceGeneroImp;
import com.setas.service.ServiceLocalizacion;
import com.setas.service.ServiceLocalizacionImp;
import com.setas.service.ServiceLugar;
import com.setas.service.ServiceLugarImp;
import com.setas.service.ServiceSeta;
import com.setas.service.ServiceSetaImp;
import com.setas.util.Accion;

public class InsertarLocalizacionAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		Localizacion localizacion = new Localizacion();
		ServiceLocalizacion sf = new ServiceLocalizacionImp();
		
		localizacion.setLatitud(request.getParameter("latUbi"));
		localizacion.setLongitud(request.getParameter("lonUbi"));
		
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		localizacion.setUsuario(usuario);
		
		String generoEspecie = request.getParameter("setaLocalizacion");
		ServiceGenero sg = new ServiceGeneroImp();
		Genero genero = sg.recuperaGenero(generoEspecie.substring(0, generoEspecie.indexOf(" ")));
		String especie = generoEspecie.substring(generoEspecie.indexOf(" ")+1,generoEspecie.length());		
		ServiceSeta ss = new ServiceSetaImp();
		Seta seta = ss.recuperaSeta(genero.getIdgenero(), especie);
		localizacion.setSeta(seta);
		
		ServiceLugar sl = new ServiceLugarImp();
		Lugar lugar = sl.recuperaLugar(1);
		localizacion.setLugar(lugar);
		
		sf.insertarLocalizacion(localizacion);
		
		request.getSession().setAttribute("listaLocalizacion", sf.recuperarLocalizaUsu(usuario));
		
		return "Mapa.jsp";
	}

}
