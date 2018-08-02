package com.setas.accionClasificacion;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Familia;
import com.setas.modelo.Genero;
import com.setas.service.ServiceGenero;
import com.setas.service.ServiceGeneroImp;
import com.setas.util.Accion;

public class ModificarGeneroAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceGenero sg = new ServiceGeneroImp();
		Enumeration<String> parametros = request.getParameterNames();
		String parametro;
		while(parametros.hasMoreElements()) {
			parametro = parametros.nextElement();
			String genero = parametro.substring(9, parametro.length());
			String nuevoGenero = request.getParameter("modificar"+genero);
			Genero unGenero = sg.recuperaGenero(genero);
			unGenero.setGenero(nuevoGenero);
			sg.modificarGenero(unGenero);
		}
		Familia familia = (Familia) request.getAttribute("familia");
		return "genero.do?familia="+familia.getFamilia().toString();
	}

}
