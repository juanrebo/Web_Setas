package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Familia;
import com.setas.service.ServiceFamilia;
import com.setas.service.ServiceFamiliaImp;
import com.setas.service.ServiceGenero;
import com.setas.service.ServiceGeneroImp;
import com.setas.util.Accion;

public class GeneroAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceFamilia sf = new ServiceFamiliaImp();
		String familia = request.getParameter("familia");
		Familia unaFamilia = sf.recuperaFamilia(familia);
		request.getSession().setAttribute("familia", unaFamilia);
		
		ServiceGenero sg = new ServiceGeneroImp();
		request.getSession().setAttribute("listaGenero", sg.getGeneroFamilia(unaFamilia));
		
		return "genero.jsp";
	}

}
