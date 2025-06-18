package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.EspecialidadEntity;
import org.cibertec.reservas.service.EspecialidadService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadServiceImpl extends GenericServiceImpl<EspecialidadEntity, Integer> implements EspecialidadService {

	public EspecialidadServiceImpl(JpaRepository<EspecialidadEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}
