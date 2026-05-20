package br.com.charles.clinica_medica_api.service;

import br.com.charles.clinica_medica_api.exception.PacienteNaoEncontradoException;
import br.com.charles.clinica_medica_api.model.Paciente;
import br.com.charles.clinica_medica_api.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente cadastrar(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> listar() {
        return repository.findAll();
    }

    public Paciente buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new PacienteNaoEncontradoException(
                                "Paciente não encontrado"
                        ));
    }

    public Paciente atualizar(Long id, Paciente paciente) {

        Paciente existente = repository.findById(id).orElse(null);

        if (existente != null) {

            existente.setNome(paciente.getNome());
            existente.setCpf(paciente.getCpf());
            existente.setIdade(paciente.getIdade());

            return repository.save(existente);
        }

        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}