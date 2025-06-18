package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.EspecialistaEntity;
import org.cibertec.reservas.repository.EspecialistaRepository;
import org.cibertec.reservas.service.EspecialistaService;

public class EspecialistaServiceImpl extends GenericServiceImpl<EspecialistaEntity, Integer> implements EspecialistaService {

	public EspecialistaServiceImpl(EspecialistaRepository repositorio) {
		super(repositorio);
	}
}