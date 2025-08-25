package com.stephania.audit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.stephania.audit.dto.LoginRequest;
import com.stephania.audit.entity.Usuario;
import com.stephania.audit.repository.UsuarioRepository;
import com.stephania.audit.security.JwtUtil;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    public String login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByCorreo(request.getCorreoElectronico())
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        if (!usuario.getContrasena().equals(request.getContrasena())) {
            throw new BadCredentialsException("Contraseña incorrecta");
        }

        return jwtUtil.generateToken(usuario);
    }
}