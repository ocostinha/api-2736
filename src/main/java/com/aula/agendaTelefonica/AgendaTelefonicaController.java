package com.aula.agendaTelefonica;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/agendaTelefonica")
public class AgendaTelefonicaController {

    @Autowired
    private ContatoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoSaidaDTO postContrato(@RequestBody @Valid ContatoEntradaDTO dto) {
        ContatoEntity entity = new ContatoEntity();

        entity.setNome(dto.getNome());
        entity.setCelular(dto.getCelular());
        entity.setDddCelular(dto.getDddCelular());
        entity.setEmail(dto.getEmail());
        entity.setDataDeCricao(LocalDateTime.now());
        entity.setDataDeAtualizacao(LocalDateTime.now());

        ContatoEntity entityPersistida = repository.save(entity);

        ContatoSaidaDTO dtoSaida = new ContatoSaidaDTO();

        dtoSaida.setId(entityPersistida.getId());
        dtoSaida.setNome(entityPersistida.getNome());
        dtoSaida.setCelular(entityPersistida.getCelular());
        dtoSaida.setDddCelular(entityPersistida.getDddCelular());
        dtoSaida.setEmail(entityPersistida.getEmail());

        return dtoSaida;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContatoSaidaDTO getContato(@PathVariable Integer id) {
        ContatoEntity entitySalva = repository.findById(id).get();

        ContatoSaidaDTO  dtoSaida = new ContatoSaidaDTO();

        dtoSaida.setId(entitySalva.getId());
        dtoSaida.setNome(entitySalva.getNome());
        dtoSaida.setCelular(entitySalva.getCelular());
        dtoSaida.setDddCelular(entitySalva.getDddCelular());
        dtoSaida.setEmail(entitySalva.getEmail());

        return dtoSaida;
    }

    @GetMapping("/todos")
    public String getTodosContatos() {
        return "Get todos os contatos";
    }

    @PatchMapping("/{id}/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public String patchContato(@PathVariable String id,
                               @RequestParam String email) {
        return "Patch realizado com sucesso no id: " + id + ". Email para ser alterado " + email;
    }

    @PutMapping("/{id}/sobrescrever")
    @ResponseStatus(HttpStatus.OK)
    public String putContato(@PathVariable String id) {
        return "Put realizado com sucesso. ID: " + id;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteContato(@PathVariable String id) {
        return "Delete com sucesso. ID: " + id;
    }

}
