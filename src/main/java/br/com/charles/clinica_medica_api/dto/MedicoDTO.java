package br.com.charles.clinica_medica_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class MedicoDTO {

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 3, max = 100,
            message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotBlank(message = "Especialidade é obrigatória")
    @Size(min = 3, max = 50,
            message = "Especialidade deve ter entre 3 e 50 caracteres")
    private String especialidade;

    @NotBlank(message = "CRM é obrigatório")
    private String crm;

    @NotNull(message = "Salário é obrigatório")
    private Double salario;

    public MedicoDTO() {
    }

    public MedicoDTO(String nome,
                     String especialidade,
                     String crm,
                     Double salario) {

        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}