package org.cibertec.reservas.entity;

import jakarta.persistence.*;
        import lombok.Data;

@Data
@Entity
@Table(name="Administrador")
public class AdministradorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administrador")
    private Integer id;
}
