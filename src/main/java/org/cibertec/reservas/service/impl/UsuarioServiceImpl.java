package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.UsuarioEntity;
import org.cibertec.reservas.service.UsuarioService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<UsuarioEntity, Integer> implements UsuarioService {

	public UsuarioServiceImpl(JpaRepository<UsuarioEntity, Integer> repositorio) {
		this.repository = repositorio;
	}
//	@Override
//	public void disable(Integer id) {
//		//repositorio.desactivar(id);
//	}

}
