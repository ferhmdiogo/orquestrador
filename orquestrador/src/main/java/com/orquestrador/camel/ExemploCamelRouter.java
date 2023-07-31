package com.orquestrador.camel;

import com.orquestrador.exceptions.MensagemErrorCamelException;
import com.orquestrador.repository.ProdutoRepository;
import com.orquestrador.repository.UsuarioRepository;
import feign.FeignException;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExemploCamelRouter extends RouteBuilder {

    public static final String USUARIO = "direct:usuario";
    public static final String PRODUTO = "direct:produto";
    public static final String USUARIOERRO = "direct:usuarioErro";

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ProdutoRepository imovelRepository;

    @Override
    public void configure() throws Exception {

        this.configExceptions();
        this.acessarServicos();
        this.produto();
        this.usuarioErro();
    }

    private void configExceptions() {
        onException(FeignException.class)
                .maximumRedeliveries(2)
                .to(ExemploCamelRouter.USUARIOERRO)
                .end();
    }

    private void usuarioErro() {
        from(ExemploCamelRouter.USUARIOERRO)
                .log("----> ${body}")
                .throwException(new MensagemErrorCamelException("Usuário caiu"))
                .log("error ->${body}")
                .end();
    }

    private void acessarServicos() {
        from(ExemploCamelRouter.USUARIO)
                .bean(usuarioRepository, "retornaUsuarios()")
                .log("----> ${body}")
                .process(new UsuarioProcessor())
                .log("->${body}")
                .to(ExemploCamelRouter.PRODUTO)
                .process(new ProdutoProcessor())
                .log("->produto")
                .end();
    }

    private void produto() {
        from(ExemploCamelRouter.PRODUTO)
                .routeId("chamaImovelCamel")
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethods.GET))
                .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
                .toD("http://{{produto.url}}/produto")
                .log("----> Produto ${body}")
                .log("->${body}")
                .end();
    }

}
