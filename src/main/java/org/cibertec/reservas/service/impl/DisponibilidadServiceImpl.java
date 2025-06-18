package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.DisponibilidadEntity;
import org.cibertec.reservas.service.DisponibilidadService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DisponibilidadServiceImpl extends GenericServiceImpl<DisponibilidadEntity, Integer> implements DisponibilidadService {

	public DisponibilidadServiceImpl(JpaRepository<DisponibilidadEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}
