package com.stephania.audit.security;

import java.util.Date;
import org.springframework.stereotype.Component;
import com.stephania.audit.entity.Usuario;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {

    private final String SECRET = "clave-secreta";

    public String generateToken(Usuario usuario) {
        return Jwts.builder()
            .setSubject(usuario.getCorreoElectronico())
            .claim("rol", usuario.getRol())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 3600000))
            .signWith(SignatureAlgorithm.HS512, SECRET)
            .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }
}