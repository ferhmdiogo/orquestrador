package com.orquestrador.camel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orquestrador.repository.response.ProdutoResponse;
import com.orquestrador.repository.response.UsuarioResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        List<UsuarioResponse> body = exchange.getProperty("usuario", List.class);

        List<ProdutoResponse> produto = mapper
                .readValue(exchange.getIn().getBody(String.class), new TypeReference<List<ProdutoResponse>>(){});
        body.forEach(usuarioResponse -> {
            usuarioResponse.setProduto(produto.stream()
                    .filter(produtoResponse -> produtoResponse.getUsuarioId().equals(usuarioResponse.getId()))
                    .collect(Collectors.toList()));
        });
        exchange.setProperty("imovel", body);
        exchange.getIn().setBody(body);
    }

}
