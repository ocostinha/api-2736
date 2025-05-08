package com.aula.agendaTelefonica;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/agendaTelefonica")
public class AgendaTelefonicaController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String postContrato() {
        return "Fiz um post";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getContato(@PathVariable String id) {
        return "Esse é o ID que você me mandou: " + id;
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
