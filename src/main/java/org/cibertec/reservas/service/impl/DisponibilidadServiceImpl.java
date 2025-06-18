package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.DisponibilidadEntity;
import org.cibertec.reservas.repository.DisponibilidadRepository;
import org.cibertec.reservas.service.DisponibilidadService;

public class DisponibilidadServiceImpl extends GenericServiceImpl<DisponibilidadEntity, Integer> implements DisponibilidadService {

	public DisponibilidadServiceImpl(DisponibilidadRepository repositorio) {
		super(repositorio);
	}

}
