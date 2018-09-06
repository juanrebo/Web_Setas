package com.setas.service;

import java.util.List;

import com.setas.dao.LugarDAO;
import com.setas.modelo.Lugar;
import com.setas.modelo.Usuario;
import com.setas.util.DAOFactory;

public class ServiceLugarImp implements ServiceLugar {
	LugarDAO ld = DAOFactory.getSingleton().getLugar();
	
	@Override
	public void insertarLugar(Lugar lugar) {
		ld.insertarLugar(lugar);
	}
	
	@Override
	public void eliminarLugar(Lugar lugar) {
		ld.eliminarLugar(lugar);
	}
	
	@Override
	public Lugar recuperaLugar(int idlugar) {
		return ld.recuperaLugar(idlugar);
	}

	@Override
	public List<Lugar> recuperaLugares(Usuario usuario) {
		return ld.recuperaLugares(usuario);
	}

}
