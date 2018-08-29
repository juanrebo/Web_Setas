package com.setas.service;

import com.setas.dao.LugarDAO;
import com.setas.modelo.Lugar;
import com.setas.util.DAOFactory;

public class ServiceLugarImp implements ServiceLugar {
	LugarDAO ld = DAOFactory.getSingleton().getLugar();
	
	@Override
	public Lugar getLugarId(int idlugar) {
		return ld.getLugarId(idlugar);
	}

}
