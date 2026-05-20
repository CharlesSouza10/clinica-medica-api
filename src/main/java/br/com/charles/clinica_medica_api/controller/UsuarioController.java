package br.com.charles.clinica_medica_api.controller;

import br.com.charles.clinica_medica_api.model.Usuario;
import br.com.charles.clinica_medica_api.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository repository;

    private final BCryptPasswordEncoder encoder;

    public UsuarioController(
            UsuarioRepository repository,
            BCryptPasswordEncoder encoder) {

        this.repository = repository;
        this.encoder = encoder;
    }

    @PostMapping
    public Usuario cadastrar(
            @RequestBody Usuario usuario) {

        String senhaCriptografada =
                encoder.encode(usuario.getSenha());

        usuario.setSenha(senhaCriptografada);

        return repository.save(usuario);
    }
}