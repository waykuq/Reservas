package org.cibertec.reservas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Especialista")
public class EspecialistaEntity extends UsuarioEntity {

    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private EspecialidadEntity especialidad;

}
