package com.aula.agendaTelefonica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContatoSaidaDTO {

    private Integer id;

    private String nome;

    private Integer dddCelular;

    private Integer celular;

    private String email;

    public ContatoSaidaDTO(ContatoEntity contato) {
        this.id = contato.getId();
        this.nome = contato.getNome();
        this.dddCelular = contato.getDddCelular();
        this.celular = contato.getCelular();
        this.email = contato.getEmail();
    }

}
