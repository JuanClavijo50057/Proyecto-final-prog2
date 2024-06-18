package com.registro.app.repository;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_LIBROS")
public class LibroRepository {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "autor")
    private String autor;
    @Column(name = "genero")
    private String genero;
    @Column(name = "fecha_publicacion")
    private Date fecha_publicacion;
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "cantidad_disponible")
    private int cantidad_disponible;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "imagen_portada")
    private String imagen_portada;

}