package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.EspecialistaEntity;
import org.cibertec.reservas.service.EspecialistaService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EspecialistaServiceImpl extends GenericServiceImpl<EspecialistaEntity, Integer> implements EspecialistaService {

	public EspecialistaServiceImpl(JpaRepository<EspecialistaEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}