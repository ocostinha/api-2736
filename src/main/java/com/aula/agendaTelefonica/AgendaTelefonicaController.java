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
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/agendaTelefonica")
public class AgendaTelefonicaController {

    @Autowired
    private ContatoRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoSaidaDTO postContrato(@RequestBody @Valid ContatoEntradaDTO dto) {
        ContatoEntity entity = repository.save(new ContatoEntity(dto));

        return new ContatoSaidaDTO(entity);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContatoSaidaDTO getContato(@PathVariable Integer id) {
        ContatoEntity entity = repository.findById(id).get();

        return new ContatoSaidaDTO(entity);
    }

    @GetMapping("/todos")
    public List<ContatoSaidaDTO> getTodosContatos() {
        List<ContatoEntity> listaEntity = repository.findAll();
        List<ContatoSaidaDTO> listaContatosSaida = new ArrayList<>();

        listaEntity.forEach(contato -> {
            listaContatosSaida.add(new ContatoSaidaDTO(contato));
        });

        return listaContatosSaida;
    }

    @PatchMapping("/{id}/atualizar")
    @ResponseStatus(HttpStatus.OK)
    public ContatoSaidaDTO patchContato(@PathVariable Integer id,
                                        @RequestParam String email) {
        ContatoEntity entity = repository.findById(id).get();

        entity.setEmail(email);
        entity.setDataDeAtualizacao(LocalDateTime.now());

        ContatoEntity entityAtualizada = repository.save(entity);

        return new ContatoSaidaDTO(entityAtualizada);
    }

    @PutMapping("/{id}/sobrescrever")
    @ResponseStatus(HttpStatus.OK)
    public ContatoSaidaDTO putContato(@PathVariable Integer id,
                                      @RequestBody @Valid ContatoEntradaDTO dto) {
        ContatoEntity entity = repository.findById(id).get();

        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setDddCelular(dto.getDddCelular());
        entity.setCelular(dto.getCelular());
        entity.setDataDeAtualizacao(LocalDateTime.now());

        ContatoEntity entityAtualizada = repository.save(entity);

        return new ContatoSaidaDTO(entityAtualizada);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ContatoSaidaDTO deleteContato(@PathVariable Integer id) {
        ContatoEntity entity = repository.findById(id).get();

        repository.delete(entity);

        return new ContatoSaidaDTO(entity);
    }

}
