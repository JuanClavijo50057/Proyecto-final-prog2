package com.biblioteca.gestion.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.gestion.app.model.Libro;
import com.biblioteca.gestion.app.repository.LibroRepository;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    @PutMapping("/{id}")
    public Libro editarLibro(@PathVariable Long id, @RequestBody Libro libroDetalles) {
        Libro libro = libroRepository.findById(id).orElseThrow();
        libro.setTitulo(libroDetalles.getTitulo());
        libro.setAutor(libroDetalles.getAutor());
        libro.setGenero(libroDetalles.getGenero());
        libro.setFechaPublicacion(libroDetalles.getFechaPublicacion());
        libro.setIsbn(libroDetalles.getIsbn());
        libro.setCantidadDisponible(libroDetalles.getCantidadDisponible());
        libro.setDescripcion(libroDetalles.getDescripcion());
        libro.setImagenPortada(libroDetalles.getImagenPortada());
        return libroRepository.save(libro);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroRepository.deleteById(id);
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Libro buscarLibro(@PathVariable Long id) {
        return libroRepository.findById(id).orElseThrow();
    }
}
