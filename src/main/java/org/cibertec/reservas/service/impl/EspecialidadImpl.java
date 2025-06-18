package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.EspecialidadEntity;
import org.cibertec.reservas.repository.EspecialidadRepository;
import org.cibertec.reservas.repository.impl.EspecialidadRepositoryImpl;
import org.cibertec.reservas.service.EspecialidadService;

public class EspecialidadImpl extends GenericServiceImpl<EspecialidadEntity, Integer> implements EspecialidadService {
	private EspecialidadRepository repositorio;
	
	public EspecialidadImpl() {
		super(new EspecialidadRepositoryImpl());
		this.repositorio = (EspecialidadRepository) super.repositorio;
	}
}
