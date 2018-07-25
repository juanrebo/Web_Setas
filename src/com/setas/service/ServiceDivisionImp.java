package com.setas.service;

import java.util.List;

import com.setas.dao.DivisionDAO;
import com.setas.modelo.Division;
import com.setas.util.DAOFactory;

public class ServiceDivisionImp implements ServiceDivision {
	DivisionDAO dd = DAOFactory.getSingleton().getDivision();
	
	@Override
	public void insertarDivision(Division division) {
		dd.insertarDivision(division);
	}

	@Override
	public List<Division> getDivision() {
		return dd.getDivision();
	}

	@Override
	public void modificarDivision(Division division) {
		dd.modificarDivision(division);
	}

	@Override
	public void eliminarDivision(Division division) {
		dd.eliminarDivision(division);
	}

}
