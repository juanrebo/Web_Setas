package com.setas.accionClasificacion;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Familia;
import com.setas.modelo.Orden;
import com.setas.service.ServiceFamilia;
import com.setas.service.ServiceFamiliaImp;
import com.setas.util.Accion;

public class ModificarFamiliaAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceFamilia sf = new ServiceFamiliaImp();
		Enumeration<String> parametros = request.getParameterNames();
		String parametro;
		while(parametros.hasMoreElements()) {
			parametro = parametros.nextElement();
			String familia = parametro.substring(9, parametro.length());
			String nuevaFamilia = request.getParameter("modificar"+familia);
			Familia unaFamilia = sf.recuperaFamilia(familia);
			unaFamilia.setFamilia(nuevaFamilia);
			sf.modificarFamilia(unaFamilia);
		}
		Orden orden = (Orden) request.getAttribute("orden");
		return "familia.do?orden="+orden.getOrden();
	}

}
