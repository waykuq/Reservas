package org.cibertec.reservas.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Cliente")
public class ClienteEntity extends UsuarioEntity {

}
