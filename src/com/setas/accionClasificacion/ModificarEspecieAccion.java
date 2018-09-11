package com.setas.accionClasificacion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Genero;
import com.setas.modelo.Seta;
import com.setas.modelo.SetaId;
import com.setas.service.ServiceSeta;
import com.setas.service.ServiceSetaImp;
import com.setas.util.Accion;

public class ModificarEspecieAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
			String especie = request.getParameter("actual");
			String nuevaEspecie = request.getParameter("nuevo");
			Genero genero = (Genero) request.getSession().getAttribute("genero");
			int idgenero = genero.getIdgenero();
			ServiceSeta ss = new ServiceSetaImp();
			Seta seta = ss.recuperaSeta(idgenero, especie);
			seta.getId().setEspecie(nuevaEspecie);
			ss.modificarSeta(seta);
			
			return "especie.do?genero="+genero.getGenero().toString();

	}
}
