package org.cibertec.reservas.repository;

import org.cibertec.reservas.entity.CitaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<CitaEntity, Integer> {
}
