package com.biblioteca.gestion.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.gestion.app.model.Usuario;
import com.biblioteca.gestion.app.repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario editarPerfil(@PathVariable Long id, @RequestBody Usuario usuarioDetalles) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNombre(usuarioDetalles.getNombre());
        usuario.setApellido(usuarioDetalles.getApellido());
        usuario.setEmail(usuarioDetalles.getEmail());
        usuario.setContrasena(usuarioDetalles.getContrasena());
        usuario.setRol(usuarioDetalles.getRol());
        usuario.setFechaRegistro(usuarioDetalles.getFechaRegistro());
        return usuarioRepository.save(usuario);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
