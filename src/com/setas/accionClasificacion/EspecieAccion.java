package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Genero;
import com.setas.service.ServiceGenero;
import com.setas.service.ServiceGeneroImp;
import com.setas.service.ServiceSeta;
import com.setas.service.ServiceSetaImp;
import com.setas.util.Accion;

public class EspecieAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceGenero sg = new ServiceGeneroImp();
		String genero = request.getParameter("genero");
		Genero unGenero = sg.recuperaGenero(genero);
		request.getSession().setAttribute("genero", unGenero);
		
		ServiceSeta ss = new ServiceSetaImp();
		request.getSession().setAttribute("listaSeta", ss.getSetaGenero(unGenero));
		
		return "especie.jsp";
	}

}
