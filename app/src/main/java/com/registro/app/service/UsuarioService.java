package com.registro.app.service;

import java.util.ArrayList;

import com.registro.app.domain.Usuario;

public interface UsuarioService {

    void AgregarUsuario(Usuario usuario);

    ArrayList<Usuario> ListarUsuarios();

}