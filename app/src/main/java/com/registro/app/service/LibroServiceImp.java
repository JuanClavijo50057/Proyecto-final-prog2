package com.registro.app.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.registro.app.domain.Libro;

@Service
public class LibroServiceImp implements LibroService {

    private final ArrayList<Libro> libros = new ArrayList<>();

    @Override
    public void AgregarLibro(Libro libro) {
        libros.add(libro);

    }

    @Override
    public void EliminarLibro(String isbn) {
        libros.removeIf(libro -> libro.getIsbn().equals(isbn));
    }

    @Override
    public Libro BuscarLibro(String filtro) {
        return libros.stream()
                .filter(libro -> libro.getIsbn().equals(filtro) || libro.getTitulo().equals(filtro)
                        || libro.getAutor().equals(filtro) || libro.getGenero().equals(filtro))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ArrayList<Libro> ListarLibros() {
        for (Libro libro : libros) {
            return libros;
        }
        return null;

    }

    @Override
    public void EditarLibro(Libro libroNuevo) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(libroNuevo.getIsbn())) {

                libros.set(i, libroNuevo);

                break;

            }
        }
    }
}