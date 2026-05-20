package br.com.charles.clinica_medica_api.repository;

import br.com.charles.clinica_medica_api.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}