package com.aula.agendaTelefonica;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "contato")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column(name = "ddd")
    private Integer dddCelular;

    @Column
    private Integer celular;

    @Column
    private String email;

    @Column
    private LocalDateTime dataDeCricao = LocalDateTime.now();

    @Column
    private LocalDateTime dataDeAtualizacao = LocalDateTime.now();

    public ContatoEntity() {
    }

    public ContatoEntity(Integer id, String nome, Integer dddCelular, Integer celular, String email, LocalDateTime dataDeCricao, LocalDateTime dataDeAtualizacao) {
        this.id = id;
        this.nome = nome;
        this.dddCelular = dddCelular;
        this.celular = celular;
        this.email = email;
        this.dataDeCricao = dataDeCricao;
        this.dataDeAtualizacao = dataDeAtualizacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDddCelular() {
        return dddCelular;
    }

    public void setDddCelular(Integer dddCelular) {
        this.dddCelular = dddCelular;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDataDeCricao() {
        return dataDeCricao;
    }

    public void setDataDeCricao(LocalDateTime dataDeCricao) {
        this.dataDeCricao = dataDeCricao;
    }

    public LocalDateTime getDataDeAtualizacao() {
        return dataDeAtualizacao;
    }

    public void setDataDeAtualizacao(LocalDateTime dataDeAtualizacao) {
        this.dataDeAtualizacao = dataDeAtualizacao;
    }

}
