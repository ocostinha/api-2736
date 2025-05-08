package com.aula.agendaTelefonica;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/agendaTelefonica")
public class AgendaTelefonicaController {

    @GetMapping("/{id}")
    public String getContato(@PathVariable String id) {
        return "Esse é o ID que você me mandou: " + id;
    }

    @PostMapping
    public String postContrato() {
        return "Fiz um post";
    }
}
