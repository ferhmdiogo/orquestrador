package com.cadastro.produto.config;

import com.cadastro.produto.domain.ProdutoDomain;
import com.cadastro.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProdutoInit implements ApplicationRunner {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var produto = ProdutoDomain.builder()
                .usuarioId(1L)
                .nomeProduto("Leite Integral")
                .descricao("Leite Integral tipo 1")
                .build();
        produtoRepository.save(produto);

        var produto2 = ProdutoDomain.builder()
                .usuarioId(1L)
                .nomeProduto("Leite Desnatado")
                .descricao("Leite Desnatado tipo 2")
                .build();

        produtoRepository.save(produto2);

        var produto3 = ProdutoDomain.builder()
                .usuarioId(1L)
                .nomeProduto("Leite SemiDesnatado")
                .descricao("Leite SemiDesnatado tipo 2")
                .build();

        produtoRepository.save(produto3);

        produtoRepository.save(produto3);
    }
}
