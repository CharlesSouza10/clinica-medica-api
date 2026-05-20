package br.com.charles.clinica_medica_api.controller;

import br.com.charles.clinica_medica_api.dto.MedicoDTO;
import br.com.charles.clinica_medica_api.model.Medico;
import br.com.charles.clinica_medica_api.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoRepository repository;

    public MedicoController(MedicoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Medico cadastrar(@RequestBody @Valid MedicoDTO dto) {

        Medico medico = new Medico();

        medico.setNome(dto.getNome());
        medico.setEspecialidade(dto.getEspecialidade());
        medico.setCrm(dto.getCrm());
        medico.setSalario(dto.getSalario());

        return repository.save(medico);
    }

    @GetMapping
    public List<Medico> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Medico buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Medico atualizar(@PathVariable Long id,
                            @RequestBody @Valid MedicoDTO dto) {

        Medico existente = repository.findById(id).orElse(null);

        if (existente != null) {

            existente.setNome(dto.getNome());
            existente.setEspecialidade(dto.getEspecialidade());
            existente.setCrm(dto.getCrm());
            existente.setSalario(dto.getSalario());

            return repository.save(existente);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}