package com.setas.accionClasificacion;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Genero;
import com.setas.modelo.Seta;
import com.setas.modelo.SetaId;
import com.setas.service.ServiceSeta;
import com.setas.service.ServiceSetaImp;
import com.setas.util.Accion;

public class InsertarEspecieAccion extends Accion{

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		try {
			ServiceSeta ss = new ServiceSetaImp();
			Genero genero = (Genero) request.getSession().getAttribute("genero");
			Seta seta = new Seta();
			SetaId setaid = new SetaId();
			setaid.setEspecie(request.getParameter("nuevaEspecie"));
			setaid.setIdgenero(genero.getIdgenero());
			seta.setId(setaid);
			seta.setGenero(genero);
			ss.insertarSeta(seta);
			
			List<Seta> todasSetas = ss.getSeta();
			request.getSession().setAttribute("todasSetas", todasSetas);
			
			return "especie.do?genero="+genero.getGenero().toString();
		}catch(Exception e) {
			request.setAttribute("error", e.getCause());
			return "Error.jsp";
		}
	}
}
