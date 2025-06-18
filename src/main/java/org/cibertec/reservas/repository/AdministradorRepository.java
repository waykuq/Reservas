package org.cibertec.reservas.repository;

import org.cibertec.reservas.entity.AdministradorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministradorRepository extends JpaRepository<AdministradorEntity, Integer> {
}
