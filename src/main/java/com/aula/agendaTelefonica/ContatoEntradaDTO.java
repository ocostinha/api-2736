package com.aula.agendaTelefonica;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ContatoEntradaDTO {

    @NotEmpty
    private String nome;

    @NotNull
    private Integer dddCelular;

    @NotNull
    private Integer celular;

    @NotEmpty
    private String email;

    public ContatoEntradaDTO() {

    }

    public ContatoEntradaDTO(String nome, Integer dddCelular, Integer celular, String email) {
        this.nome = nome;
        this.dddCelular = dddCelular;
        this.celular = celular;
        this.email = email;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDddCelular() {
        return this.dddCelular;
    }

    public void setDddCelular(Integer dddCelular) {
        this.dddCelular = dddCelular;
    }

    public Integer getCelular() {
        return this.celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
