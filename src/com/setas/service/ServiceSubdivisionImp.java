package com.setas.service;

import java.util.List;

import com.setas.dao.SubdivisionDAO;
import com.setas.modelo.Division;
import com.setas.modelo.Subdivision;
import com.setas.util.DAOFactory;

public class ServiceSubdivisionImp implements ServiceSubdivision {
	SubdivisionDAO sd = DAOFactory.getSingleton().getSubdivision();
	
	@Override
	public void insertarSubdivision(Subdivision subdivision) {
		sd.insertarSubdivision(subdivision);
	}

	@Override
	public List<Subdivision> getSubdivision() {
		return sd.getSubdivision();
	}

	@Override
	public List<Subdivision> getSubdivisonDivision(int division) {
		return sd.getSubdivisonDivision(division);
	}

	@Override
	public void modificarSubdivision(Subdivision subdivision) {
		sd.modificarSubdivision(subdivision);
	}

	@Override
	public void eliminarSubdivision(Subdivision subdivision) {
		sd.eliminarSubdivision(subdivision);
	}

	@Override
	public Subdivision recuperaSubdivision(int idsubdivision) {
		return sd.recuperaSubdivision(idsubdivision);
	}

}
