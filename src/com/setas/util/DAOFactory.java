package com.setas.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.setas.dao.DivisionDAO;
import com.setas.dao.FamiliaDAO;
import com.setas.dao.RolDAO;
import com.setas.dao.SetaDAO;
import com.setas.dao.UsuarioDAO;
import com.setas.daoimp.DivisionDAOImp;
import com.setas.daoimp.FamiliaDAOImp;
import com.setas.daoimp.RolDAOImp;
import com.setas.daoimp.SetaDAOImp;
import com.setas.daoimp.UsuarioDAOImp;

public class DAOFactory {
	private final static DAOFactory INSTANCE = new DAOFactory();
	SessionFactory sf;
	
	private DAOFactory() {
		sf = new Configuration().configure().buildSessionFactory();
	}

	public static DAOFactory getSingleton() {
		return INSTANCE;
	}
	
	public RolDAO getRol() {
		return new RolDAOImp(sf);
	}
	
	public SetaDAO getSeta() {
		return new SetaDAOImp(sf);
	}
	
	public UsuarioDAO getUsuario() {
		return new UsuarioDAOImp(sf);
	}
	
	public DivisionDAO getDivision() {
		return new DivisionDAOImp(sf);
	}
	
	public FamiliaDAO getFamilia() {
		return new FamiliaDAOImp(sf);
	}
}
