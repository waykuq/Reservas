package org.cibertec.reservas.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;


@Data
@Entity
@Table(name="Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @Column(name = "dni")
    private String dni;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contraseña")
    private String contraseña;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fecha_inscripcion")
    private LocalDate fecha_inscripcion;

    @Column(name = "estado")
    private Boolean estado;

}
