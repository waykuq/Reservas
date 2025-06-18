package org.cibertec.reservas.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import jakarta.persistence.Persistence;
import org.cibertec.reservas.repository.GenericRepository;


public abstract class GenericRepositoryImpl<T, ID> implements GenericRepository<T, ID> {

    protected EntityManagerFactory emf;
    protected Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public GenericRepositoryImpl() {
        emf = Persistence.createEntityManagerFactory("T1");
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void grabar(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al guardar la entidad: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(T entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar la entidad: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(ID id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            T entity = em.find(entityClass, id);
            if (entity != null) {
                em.remove(entity);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la entidad: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    @Override
    public T buscarporID(ID id) {
        EntityManager em = getEntityManager();
        try {
            T entity = em.find(entityClass, id);
            return (entity);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // O podrías relanzar una excepción personalizada
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> obtenerTodos() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("FROM " + entityClass.getName(), entityClass).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Devuelve una lista vacía en caso de error
        } finally {
            em.close();
        }
    }

}