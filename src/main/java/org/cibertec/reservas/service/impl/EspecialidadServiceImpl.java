package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.EspecialidadEntity;
import org.cibertec.reservas.repository.EspecialidadRepository;
import org.cibertec.reservas.service.EspecialidadService;

public class EspecialidadServiceImpl extends GenericServiceImpl<EspecialidadEntity, Integer> implements EspecialidadService {

	public EspecialidadServiceImpl(EspecialidadRepository repositorio) {
		super(repositorio);
	}

}
