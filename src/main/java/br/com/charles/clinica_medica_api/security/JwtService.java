package br.com.charles.clinica_medica_api.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    private final String SECRET =
            "minha-chave-secreta-super-segura-123456";

    public String gerarToken(String usuario) {

        SecretKey key = Keys.hmacShaKeyFor(
                SECRET.getBytes(StandardCharsets.UTF_8)
        );

        return Jwts.builder()

                .subject(usuario)

                .issuedAt(new Date())

                .expiration(
                        new Date(System.currentTimeMillis()
                                + 1000 * 60 * 60)
                )

                .signWith(key)

                .compact();
    }
}