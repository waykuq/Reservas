package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.CitaEntity;
import org.cibertec.reservas.repository.CitaRepository;
import org.cibertec.reservas.service.CitaService;

public class CitaServiceImpl extends GenericServiceImpl<CitaEntity, Integer> implements CitaService {

	public CitaServiceImpl(CitaRepository repositorio) {
		super(repositorio);
	}
}
