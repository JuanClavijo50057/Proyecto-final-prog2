package com.registro.app.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.registro.app.domain.Usuario;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private final ArrayList<Usuario> Usuarios = new ArrayList<>();

    @Override
    public void AgregarUsuario(Usuario usuario) {
        Usuarios.add(usuario);

    }

    @Override
    public ArrayList<Usuario> ListarUsuarios() {
        for (Usuario usuario : Usuarios) {
            return Usuarios;
        }
        return null;

    }

}