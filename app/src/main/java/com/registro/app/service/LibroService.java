package com.registro.app.service;

import java.util.ArrayList;

import com.registro.app.domain.Libro;

public interface LibroService {

    void AgregarLibro(Libro libro);

    void EliminarLibro(String isbn);

    ArrayList<Libro> ListarLibros();

    Libro BuscarLibro(String filtro);

    void EditarLibro(Libro libroNuevo);

}