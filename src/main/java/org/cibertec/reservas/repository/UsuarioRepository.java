package org.cibertec.reservas.repository;

import org.cibertec.reservas.entity.UsuarioEntity;

public interface UsuarioRepository extends GenericRepository<UsuarioEntity, Integer> {
    void desactivar(Integer id);
}
