package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.DisponibilidadEntity;
import org.cibertec.reservas.repository.DisponibilidadRepository;
import org.cibertec.reservas.repository.impl.DisponibilidadRepositoryImpl;
import org.cibertec.reservas.service.DisponibilidadService;

public class DisponibilidadServiceImpl extends GenericServiceImpl<DisponibilidadEntity, Integer> implements DisponibilidadService {
	private DisponibilidadRepository repositorio;
	
	public DisponibilidadServiceImpl() {
		super(new DisponibilidadRepositoryImpl());
		this.repositorio = (DisponibilidadRepository) super.repositorio;
	}
}
