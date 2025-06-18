package org.cibertec.reservas.service;

import org.cibertec.reservas.entity.UsuarioEntity;

public interface UsuarioService extends GenericService<UsuarioEntity, Integer> {

    void disable(Integer id);
}
