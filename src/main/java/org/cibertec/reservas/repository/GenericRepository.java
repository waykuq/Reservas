package org.cibertec.reservas.repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    T buscarporID(ID id);
    List<T> obtenerTodos();
    void grabar(T entity);
    void actualizar(T entity);
    void eliminar(ID id);
}