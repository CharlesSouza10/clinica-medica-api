package br.com.charles.clinica_medica_api.repository;

import br.com.charles.clinica_medica_api.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}