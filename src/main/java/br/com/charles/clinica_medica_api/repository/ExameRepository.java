package br.com.charles.clinica_medica_api.repository;

import br.com.charles.clinica_medica_api.model.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExameRepository extends JpaRepository<Exame, Long> {
}