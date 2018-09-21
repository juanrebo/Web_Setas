package com.setas.accionSetas;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.setas.modelo.Foto;
import com.setas.modelo.Genero;
import com.setas.modelo.Nombre;
import com.setas.modelo.Seta;
import com.setas.service.ServiceFoto;
import com.setas.service.ServiceFotoImp;
import com.setas.service.ServiceGenero;
import com.setas.service.ServiceGeneroImp;
import com.setas.service.ServiceNombre;
import com.setas.service.ServiceNombreImp;
import com.setas.service.ServiceSeta;
import com.setas.service.ServiceSetaImp;
import com.setas.util.Accion;

public class InsertarSetaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServiceSeta ss = new ServiceSetaImp();
		Seta seta = new Seta();
		ServiceGenero sg = new ServiceGeneroImp();
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
		
		String ruta = request.getParameter("ruta");
		if(ruta != "") {
			ServiceFoto sf = new ServiceFotoImp();
			String derecho = request.getParameter("derecho");
			Foto foto = new Foto();
			foto.setRuta(ruta);
			foto.setDerecho(derecho);
			foto.setSeta(seta);
			sf.insertarFoto(foto);
		}		
		
		String nombrereq = request.getParameter("nombre");
		if(nombrereq != "") {
			String idiomareq = request.getParameter("idioma");
			Nombre nombre = new Nombre();
			nombre.setIdioma(idiomareq);
			nombre.setNombre(nombrereq);
			nombre.setSeta(seta);
			ServiceNombre sn = new ServiceNombreImp();
			sn.insertarNombre(nombre);
		}
		
		List<Seta> todasSetas = ss.getSeta();
		request.getServletContext().setAttribute("todasSetas", todasSetas);
		
		return "REDIRECT ../seta.do?genero="+seta.getGenero().getGenero()+"&especie="+seta.getEspecie();
	}

}
