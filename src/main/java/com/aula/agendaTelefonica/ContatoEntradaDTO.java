package com.aula.agendaTelefonica;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContatoEntradaDTO {

    @NotEmpty(message = "Por favor, informe seu nome completo")
    @Size(min = 5, max = 20, message = "Nome deve ter entre 5 e 20 caracteres")
    private String nome;

    @NotNull
    @Max(value = 99, message = "Número maximo de caracteres permitido 2")
    @Min(value = 11, message = "Número mínimo de caracteres permitidos 2")
    private Integer dddCelular;

    @NotNull
    private Integer celular;

    @NotEmpty
    private String email;

}
