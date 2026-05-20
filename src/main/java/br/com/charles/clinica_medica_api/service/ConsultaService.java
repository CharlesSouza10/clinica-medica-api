package br.com.charles.clinica_medica_api.service;

import br.com.charles.clinica_medica_api.model.Consulta;
import br.com.charles.clinica_medica_api.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public Consulta cadastrar(Consulta consulta) {
        return repository.save(consulta);
    }

    public List<Consulta> cadastrarTodos(List<Consulta> consultas) {
        return repository.saveAll(consultas);
    }

    public List<Consulta> listar() {
        return repository.findAll();
    }

    public Consulta buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Consulta atualizar(Long id, Consulta consulta) {

        Consulta existente = repository.findById(id).orElse(null);

        if (existente != null) {

            existente.setData(consulta.getData());
            existente.setObservacoes(consulta.getObservacoes());
            existente.setPaciente(consulta.getPaciente());
            existente.setMedico(consulta.getMedico());

            return repository.save(existente);
        }

        return null;
    }

    public List<Consulta> atualizarTodos(List<Consulta> consultas) {
        return repository.saveAll(consultas);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public void deletarTodos() {
        repository.deleteAll();
    }
}