package br.com.charles.clinica_medica_api.controller;

import br.com.charles.clinica_medica_api.model.Usuario;
import br.com.charles.clinica_medica_api.repository.UsuarioRepository;
import br.com.charles.clinica_medica_api.security.JwtService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    private final UsuarioRepository repository;

    private final BCryptPasswordEncoder encoder;

    public AuthController(
            JwtService jwtService,
            UsuarioRepository repository,
            BCryptPasswordEncoder encoder) {

        this.jwtService = jwtService;
        this.repository = repository;
        this.encoder = encoder;
    }

    @PostMapping("/login")
    public Map<String, String> login(
            @RequestParam String usuario,
            @RequestParam String senha) {

        Optional<Usuario> usuarioBanco =
                repository.findByLogin(usuario);

        if (usuarioBanco.isPresent()) {

            Usuario usuarioEncontrado =
                    usuarioBanco.get();

            boolean senhaCorreta =
                    encoder.matches(
                            senha,
                            usuarioEncontrado.getSenha()
                    );

            if (senhaCorreta) {

                String token =
                        jwtService.gerarToken(usuario);

                Map<String, String> resposta =
                        new HashMap<>();

                resposta.put("token", token);

                return resposta;
            }
        }

        throw new RuntimeException(
                "Usuário ou senha inválidos"
        );
    }
}