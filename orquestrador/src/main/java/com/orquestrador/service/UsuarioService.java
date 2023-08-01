package com.orquestrador.service;

import com.orquestrador.camel.ExemploCamelRouter;
import org.apache.camel.CamelContext;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Produce("activemq:topic:in")
    private ProducerTemplate template;

    public List listaUsuarios(){
        return template.requestBody(ExemploCamelRouter.USUARIO, null, List.class);
    }

}
