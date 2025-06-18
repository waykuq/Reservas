package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.CitaEntity;
import org.cibertec.reservas.repository.CitaRepository;
import org.cibertec.reservas.repository.impl.CitaRepositoryImpl;
import org.cibertec.reservas.service.CitaService;

public class CitaServiceImpl extends GenericServiceImpl<CitaEntity, Integer> implements CitaService {
	private CitaRepository repositorio;
	
	public CitaServiceImpl() {
		super(new CitaRepositoryImpl());
		this.repositorio = (CitaRepository) super.repositorio;
	}
}
