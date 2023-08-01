package com.orquestrador.controller;

import com.orquestrador.repository.response.UsuarioResponse;
import com.orquestrador.service.UsuarioService;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("exemplo")
public class ExemploController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponse> getUser(){
        return usuarioService.listaUsuarios();
    }
}
