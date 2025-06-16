package org.cibertec.reservas.entity;

import jakarta.persistence.*;
        import lombok.Data;

@Data
@Entity
@Table(name="Usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_tipo_usuario")
    private TipoUsuarioEntity tipo_usuario;

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
    private String fecha_inscripcion;

    @Column(name = "estado")
    private String estado;

}
