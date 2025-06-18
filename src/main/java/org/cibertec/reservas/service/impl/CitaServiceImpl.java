package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.CitaEntity;
import org.cibertec.reservas.service.CitaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CitaServiceImpl extends GenericServiceImpl<CitaEntity, Integer> implements CitaService {

	public CitaServiceImpl(JpaRepository<CitaEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}
