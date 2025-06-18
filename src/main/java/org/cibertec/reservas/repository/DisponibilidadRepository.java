package org.cibertec.reservas.repository;

import org.cibertec.reservas.entity.DisponibilidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisponibilidadRepository extends JpaRepository<DisponibilidadEntity, Integer> {
}