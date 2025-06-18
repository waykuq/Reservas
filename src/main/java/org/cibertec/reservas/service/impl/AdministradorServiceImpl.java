package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.AdministradorEntity;
import org.cibertec.reservas.repository.AdministradorRepository;
import org.cibertec.reservas.repository.impl.AdministradorRepositoryImpl;
import org.cibertec.reservas.service.AdministradorService;

public class AdministradorServiceImpl extends GenericServiceImpl<AdministradorEntity, Integer> implements AdministradorService {
	private AdministradorRepository repositorio;
	
	public AdministradorServiceImpl() {
		super(new AdministradorRepositoryImpl());
		this.repositorio = (AdministradorRepository) super.repositorio;
	}
}
