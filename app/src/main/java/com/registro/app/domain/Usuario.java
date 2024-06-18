package com.registro.app.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private String rol;
    private Date fecha_registro;

    public Usuario() {
    }

}