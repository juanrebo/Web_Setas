package com.setas.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.setas.dao.SetaDAO;
import com.setas.daoimp.SetaDAOImp;

public class DAOFactory {
	private final static DAOFactory INSTANCE = new DAOFactory();
	SessionFactory sf;
	
	private DAOFactory() {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	public static DAOFactory getSingleton() {
		return INSTANCE;
	}
	
	public SetaDAO getSeta() {
		return new SetaDAOImp(sf);
	}
}
