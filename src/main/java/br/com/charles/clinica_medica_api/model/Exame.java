package br.com.charles.clinica_medica_api.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Exame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoExame;

    private LocalDate data;

    private String resultado;

    @ManyToOne
    private Paciente paciente;

    public Exame() {
    }

    public Exame(Long id, String tipoExame, LocalDate data, String resultado, Paciente paciente) {
        this.id = id;
        this.tipoExame = tipoExame;
        this.data = data;
        this.resultado = resultado;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public String getTipoExame() {
        return tipoExame;
    }

    public LocalDate getData() {
        return data;
    }

    public String getResultado() {
        return resultado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}