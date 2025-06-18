package org.cibertec.reservas.entity;

import jakarta.persistence.*;
        import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name="Disponibilidad")
public class DisponibilidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disponibilidad")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_especialista")
    private EspecialistaEntity especialista;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora_inicio")
    private LocalTime  hora_inicio;
    //00:00:00

    @Column(name = "hora_fin")
    private LocalTime  hora_fin;
}
