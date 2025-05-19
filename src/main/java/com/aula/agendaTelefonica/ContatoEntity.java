package com.aula.agendaTelefonica;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "contato")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public ContatoEntity(ContatoEntradaDTO contato) {
        this.nome = contato.getNome();
        this.dddCelular = contato.getDddCelular();
        this.celular = contato.getCelular();
        this.email = contato.getEmail();
        this.dataDeCricao = LocalDateTime.now();
        this.dataDeAtualizacao = LocalDateTime.now();
    }
}
