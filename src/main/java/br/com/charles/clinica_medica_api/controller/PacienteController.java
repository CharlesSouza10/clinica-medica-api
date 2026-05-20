package br.com.charles.clinica_medica_api.controller;
import jakarta.validation.Valid;

import br.com.charles.clinica_medica_api.model.Paciente;
import br.com.charles.clinica_medica_api.service.PacienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping
    public Paciente cadastrar(@Valid @RequestBody Paciente paciente) {
        return service.cadastrar(paciente);
    }

    @GetMapping
    public List<Paciente> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Paciente atualizar(@PathVariable Long id,
                              @RequestBody Paciente paciente) {

        return service.atualizar(id, paciente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}