package br.com.charles.clinica_medica_api.repository;

import br.com.charles.clinica_medica_api.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}