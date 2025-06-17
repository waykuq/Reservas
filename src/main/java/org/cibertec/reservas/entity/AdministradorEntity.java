package org.cibertec.reservas.entity;

import jakarta.persistence.*;
        import lombok.Data;

@Data
@Entity
@Table(name="Administrador")
public class AdministradorEntity extends UsuarioEntity {

}
