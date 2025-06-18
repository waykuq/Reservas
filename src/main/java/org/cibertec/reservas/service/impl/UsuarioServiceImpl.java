package org.cibertec.reservas.service.impl;

import org.cibertec.reservas.entity.UsuarioEntity;
import org.cibertec.reservas.repository.UsuarioRepository;
import org.cibertec.reservas.repository.impl.UsuarioRepositoryImpl;
import org.cibertec.reservas.service.UsuarioService;

public class UsuarioServiceImpl extends GenericServiceImpl<UsuarioEntity, Integer> implements UsuarioService {
	private UsuarioRepository repositorio;
	
	public UsuarioServiceImpl() {
		super(new UsuarioRepositoryImpl());
		this.repositorio = (UsuarioRepository) super.repositorio;
	}

	@Override
	public void disable(Integer id) {
		repositorio.desactivar(id);
	}
}
