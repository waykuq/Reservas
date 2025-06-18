package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.ClienteEntity;
import org.cibertec.reservas.service.ClienteService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<ClienteEntity, Integer> implements ClienteService {

	public ClienteServiceImpl(JpaRepository<ClienteEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
}
