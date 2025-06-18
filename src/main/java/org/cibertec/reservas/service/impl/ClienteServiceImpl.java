package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.repository.ClienteRepository;
import org.cibertec.reservas.entity.ClienteEntity;
import org.cibertec.reservas.service.ClienteService;

public class ClienteServiceImpl extends GenericServiceImpl<ClienteEntity, Integer> implements ClienteService {

	public ClienteServiceImpl(ClienteRepository repositorio) {
		super(repositorio);
	}
}
