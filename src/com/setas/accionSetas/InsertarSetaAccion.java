package com.setas.accionSetas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Foto;
import com.setas.modelo.Genero;
import com.setas.modelo.Seta;
import com.setas.service.ServiceFoto;
import com.setas.service.ServiceFotoImp;
import com.setas.service.ServiceGenero;
import com.setas.service.ServiceGeneroImp;
import com.setas.service.ServiceSeta;
import com.setas.service.ServiceSetaImp;
import com.setas.util.Accion;

public class InsertarSetaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceSeta ss = new ServiceSetaImp();
		ServiceGenero sg = new ServiceGeneroImp();
		Seta seta = new Seta();
		Genero genero = sg.recuperaGenero(request.getParameter("genero"));
		seta.setGenero(genero);
		seta.setEspecie(request.getParameter("especie"));
		seta.setCuerpoFructifero(request.getParameter("cuerpoFructifero"));
		seta.setSombrero(request.getParameter("sombrero"));
		seta.setHimenio(request.getParameter("himenio"));
		seta.setGleba(request.getParameter("gleba"));
		seta.setEstroma(request.getParameter("estroma"));
		seta.setCarne(request.getParameter("carne"));
		seta.setLaminas(request.getParameter("laminas"));
		seta.setTubos(request.getParameter("tubos"));
		seta.setPie(request.getParameter("pie"));
		seta.setCarne(request.getParameter("carne"));
		seta.setEsporas(request.getParameter("esporas"));
		seta.setHabitat(request.getParameter("habitat"));
		seta.setComestibilidad(request.getParameter("comestibilidad"));
		ss.insertarSeta(seta);
		
		ServiceFoto sf = new ServiceFotoImp();
		Foto foto = new Foto();
		String ruta = request.getParameter("ruta");
		if(ruta != "") {
			foto.setRuta(ruta);
			foto.setSeta(seta);
			sf.insertarFoto(foto);
		}
		return "seta.do?genero="+seta.getGenero().getGenero()+"&especie="+seta.getEspecie();
	}

}
