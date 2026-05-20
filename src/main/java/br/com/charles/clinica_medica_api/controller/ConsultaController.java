package br.com.charles.clinica_medica_api.controller;

import br.com.charles.clinica_medica_api.dto.ConsultaDTO;
import br.com.charles.clinica_medica_api.model.Consulta;
import br.com.charles.clinica_medica_api.model.Medico;
import br.com.charles.clinica_medica_api.model.Paciente;
import br.com.charles.clinica_medica_api.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    public Consulta cadastrar(@RequestBody @Valid ConsultaDTO dto) {

        Consulta consulta = new Consulta();

        consulta.setData(dto.getData());
        consulta.setObservacoes(dto.getObservacoes());

        Paciente paciente = new Paciente();
        paciente.setId(dto.getPacienteId());

        Medico medico = new Medico();
        medico.setId(dto.getMedicoId());

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);

        return service.cadastrar(consulta);
    }

    @GetMapping
    public List<ConsultaDTO> listar() {

        List<Consulta> consultas = service.listar();

        return consultas.stream()
                .map(c -> new ConsultaDTO(
                        c.getData(),
                        c.getObservacoes(),
                        c.getPaciente().getId(),
                        c.getMedico().getId()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ConsultaDTO buscarPorId(@PathVariable Long id) {

        Consulta consulta = service.buscarPorId(id);

        return new ConsultaDTO(
                consulta.getData(),
                consulta.getObservacoes(),
                consulta.getPaciente().getId(),
                consulta.getMedico().getId()
        );
    }

    @PutMapping("/{id}")
    public Consulta atualizar(@PathVariable Long id,
                              @RequestBody @Valid ConsultaDTO dto) {

        Consulta consulta = new Consulta();

        consulta.setData(dto.getData());
        consulta.setObservacoes(dto.getObservacoes());

        Paciente paciente = new Paciente();
        paciente.setId(dto.getPacienteId());

        Medico medico = new Medico();
        medico.setId(dto.getMedicoId());

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);

        return service.atualizar(id, consulta);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}