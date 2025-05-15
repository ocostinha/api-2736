package com.aula.agendaTelefonica;

public class ContatoSaidaDTO {

    private Integer id;

    private String nome;

    private Integer dddCelular;

    private Integer celular;

    private String email;

    public ContatoSaidaDTO() {

    }

    public ContatoSaidaDTO(Integer id, String nome, Integer dddCelular, Integer celular, String email) {
        this.id = id;
        this.nome = nome;
        this.dddCelular = dddCelular;
        this.celular = celular;
        this.email = email;
    }

    public ContatoSaidaDTO(ContatoEntity contato) {
        this.id = contato.getId();
        this.nome = contato.getNome();
        this.dddCelular = contato.getDddCelular();
        this.celular = contato.getCelular();
        this.email = contato.getEmail();
    }

    public void setNome(final String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(final Integer celular) {
        this.celular = celular;
    }

    public Integer getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(final Integer dddCelular) {
        this.dddCelular = dddCelular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

}
