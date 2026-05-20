package br.com.charles.clinica_medica_api.service;

import br.com.charles.clinica_medica_api.model.Medico;
import br.com.charles.clinica_medica_api.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public Medico cadastrar(Medico medico) {
        return repository.save(medico);
    }

    public List<Medico> cadastrarTodos(List<Medico> medicos) {
        return repository.saveAll(medicos);
    }

    public List<Medico> listar() {
        return repository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Medico atualizar(Long id, Medico medico) {

        Medico existente = repository.findById(id).orElse(null);

        if (existente != null) {

            existente.setNome(medico.getNome());
            existente.setEspecialidade(medico.getEspecialidade());
            existente.setCrm(medico.getCrm());
            existente.setSalario(medico.getSalario());

            return repository.save(existente);
        }

        return null;
    }

    public List<Medico> atualizarTodos(List<Medico> medicos) {
        return repository.saveAll(medicos);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public void deletarTodos() {
        repository.deleteAll();
    }
}