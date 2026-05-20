package br.com.charles.clinica_medica_api.controller;

import br.com.charles.clinica_medica_api.dto.ExameDTO;
import br.com.charles.clinica_medica_api.model.Exame;
import br.com.charles.clinica_medica_api.model.Paciente;
import br.com.charles.clinica_medica_api.service.ExameService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/exames")
@CrossOrigin(origins = "*")
public class ExameController {

    private final ExameService service;

    public ExameController(ExameService service) {
        this.service = service;
    }

    @PostMapping
    public Exame cadastrar(@RequestBody @Valid ExameDTO dto) {

        Exame exame = new Exame();

        exame.setTipoExame(dto.getTipo());
        exame.setResultado(dto.getResultado());
        exame.setData(dto.getData());

        Paciente paciente = new Paciente();
        paciente.setId(dto.getPacienteId());

        exame.setPaciente(paciente);

        return service.cadastrar(exame);
    }

    @GetMapping
    public List<ExameDTO> listar() {

        List<Exame> exames = service.listar();

        return exames.stream()
                .map(e -> new ExameDTO(
                        e.getTipoExame(),
                        e.getResultado(),
                        e.getData(),
                        e.getPaciente().getId()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ExameDTO buscarPorId(@PathVariable Long id) {

        Exame exame = service.buscarPorId(id);

        return new ExameDTO(
                exame.getTipoExame(),
                exame.getResultado(),
                exame.getData(),
                exame.getPaciente().getId()
        );
    }

    @PutMapping("/{id}")
    public Exame atualizar(@PathVariable Long id,
                           @RequestBody @Valid ExameDTO dto) {

        Exame exame = new Exame();

        exame.setTipoExame(dto.getTipo());
        exame.setResultado(dto.getResultado());
        exame.setData(dto.getData());

        Paciente paciente = new Paciente();
        paciente.setId(dto.getPacienteId());

        exame.setPaciente(paciente);

        return service.atualizar(id, exame);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}