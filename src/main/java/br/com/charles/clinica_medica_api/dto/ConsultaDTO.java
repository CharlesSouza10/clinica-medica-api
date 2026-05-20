package br.com.charles.clinica_medica_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ConsultaDTO {

    @NotBlank(message = "Data é obrigatória")
    private String data;

    @NotBlank(message = "Observações são obrigatórias")
    @Size(min = 3, max = 300,
            message = "Observações devem ter entre 3 e 300 caracteres")
    private String observacoes;

    @NotNull(message = "Paciente é obrigatório")
    private Long pacienteId;

    @NotNull(message = "Médico é obrigatório")
    private Long medicoId;

    public ConsultaDTO() {
    }

    public ConsultaDTO(String data,
                       String observacoes,
                       Long pacienteId,
                       Long medicoId) {

        this.data = data;
        this.observacoes = observacoes;
        this.pacienteId = pacienteId;
        this.medicoId = medicoId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }
}