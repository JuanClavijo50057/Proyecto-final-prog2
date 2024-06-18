package com.biblioteca.gestion.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.gestion.app.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
}
