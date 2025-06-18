package org.cibertec.reservas.repository.impl;

import jakarta.persistence.EntityManager;
import org.cibertec.reservas.entity.UsuarioEntity;
import org.cibertec.reservas.repository.UsuarioRepository;

import java.lang.reflect.Method;


public class UsuarioRepositoryImpl extends GenericRepositoryImpl<UsuarioEntity, Integer> implements UsuarioRepository {

    @Override
    public void desactivar(Integer id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            UsuarioEntity entity = em.find(entityClass, id);
            if (entity != null) {
                Method setEstado = entity.getClass().getMethod("setEstado", boolean.class);
                setEstado.invoke(entity, false);
                em.merge(entity);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al desactivar la entidad: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }
}