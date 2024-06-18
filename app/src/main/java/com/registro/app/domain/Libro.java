package com.registro.app.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Libro {
    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private Date fecha_publicacion;
    private String isbn;
    private int cantidad_disponible;
    private String descripcion;
    private String imagen_portada;

    public Libro() {
    }

}