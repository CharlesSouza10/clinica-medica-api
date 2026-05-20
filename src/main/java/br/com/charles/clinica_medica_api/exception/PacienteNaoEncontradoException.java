package br.com.charles.clinica_medica_api.exception;

public class PacienteNaoEncontradoException
        extends RuntimeException {

    public PacienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}