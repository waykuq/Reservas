package org.cibertec.reservas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Cita")
public class CitaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "id_especialista")
    private EspecialistaEntity especialista;

    @ManyToOne
    @JoinColumn(name = "id_especialidad")
    private EspecialidadEntity especialidad;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "hora")
    private String hora;

    @Column(name = "nota")
    private String nota;

    @Column(name = "estado")
    private String estado;

}
