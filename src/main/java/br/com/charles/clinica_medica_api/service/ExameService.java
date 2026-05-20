package br.com.charles.clinica_medica_api.service;

import br.com.charles.clinica_medica_api.model.Exame;
import br.com.charles.clinica_medica_api.repository.ExameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExameService {

    private final ExameRepository repository;

    public ExameService(ExameRepository repository) {
        this.repository = repository;
    }

    public Exame cadastrar(Exame exame) {
        return repository.save(exame);
    }

    public List<Exame> listar() {
        return repository.findAll();
    }

    public Exame buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Exame atualizar(Long id, Exame exame) {

        Exame existente = repository.findById(id).orElse(null);

        if (existente != null) {

            existente.setTipoExame(exame.getTipoExame());
            existente.setData(exame.getData());
            existente.setResultado(exame.getResultado());
            existente.setPaciente(exame.getPaciente());

            return repository.save(existente);
        }

        return null;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}