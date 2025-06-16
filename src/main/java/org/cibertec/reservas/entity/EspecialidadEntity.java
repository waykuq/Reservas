package org.cibertec.reservas.entity;

import jakarta.persistence.*;
        import lombok.Data;

@Data
@Entity
@Table(name="Especialidad")
public class EspecialidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;
}
