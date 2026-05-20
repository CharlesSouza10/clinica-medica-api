package br.com.charles.clinica_medica_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class ExameDTO {

    @NotBlank(message = "Tipo do exame é obrigatório")
    @Size(min = 3, max = 100)
    private String tipo;

    @NotBlank(message = "Resultado é obrigatório")
    @Size(min = 3, max = 200)
    private String resultado;

    @NotNull(message = "Data é obrigatória")
    private LocalDate data;

    @NotNull(message = "Paciente é obrigatório")
    private Long pacienteId;

    public ExameDTO() {
    }

    public ExameDTO(String tipo, String resultado, LocalDate data, Long pacienteId) {
        this.tipo = tipo;
        this.resultado = resultado;
        this.data = data;
        this.pacienteId = pacienteId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }
}