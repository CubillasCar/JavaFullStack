package com.mitocode.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="usuario_rol")
@IdClass(UsuarioRolPK.class)
public class UsuarioRol {

    @Id
    private Usuario usuario;

    @Id
    private Rol rol;


}
