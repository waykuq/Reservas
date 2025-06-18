package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.AdministradorEntity;
import org.cibertec.reservas.service.AdministradorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServiceImpl extends GenericServiceImpl<AdministradorEntity, Integer> implements AdministradorService {

	public AdministradorServiceImpl(JpaRepository<AdministradorEntity, Integer> repositorio) {
		this.repository = repositorio;
	}

}
