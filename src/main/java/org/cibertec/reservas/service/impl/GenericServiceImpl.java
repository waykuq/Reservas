package org.cibertec.reservas.service.impl;

import java.util.List;

import org.cibertec.reservas.repository.GenericRepository;
import org.cibertec.reservas.service.GenericService;

public class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

    protected GenericRepository<T, ID> repositorio;

    public GenericServiceImpl(GenericRepository<T, ID> repo) {
        this.repositorio = repo;
    }

    @Override
    public T getById(ID id) {
        return repositorio.buscarporID(id);
    }

    @Override
    public List<T> getAll() {
        return repositorio.obtenerTodos();
    }

    @Override
    public void create(T entity) {
        repositorio.grabar(entity);
    }

    @Override
    public void modify(T entity) {
        repositorio.actualizar(entity);
    }

    @Override
    public void remove(ID id) {
        repositorio.eliminar(id);
    }

}