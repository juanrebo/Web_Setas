package com.setas.accionLocalizacion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Localizacion;
import com.setas.modelo.Seta;
import com.setas.modelo.Usuario;
import com.setas.service.ServiceLocalizacion;
import com.setas.service.ServiceLocalizacionImp;
import com.setas.service.ServiceSeta;
import com.setas.service.ServiceSetaImp;
import com.setas.util.Accion;

public class InsertarLocalizacionAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceSeta ss = new ServiceSetaImp();
		List<Seta> listaSetas = ss.getSeta();
		request.setAttribute("listaSetas", listaSetas);
		ServiceLocalizacion sl = new ServiceLocalizacionImp();
		List<Localizacion> listaLocalizacionUsu = sl.recuperarLocalizaUsu((Usuario) request.getSession().getAttribute("usuario"));
		request.setAttribute("listaLocalizacionUsu", listaLocalizacionUsu);
		return "usuario/insertarLocalizacion.jsp";
	}

}
