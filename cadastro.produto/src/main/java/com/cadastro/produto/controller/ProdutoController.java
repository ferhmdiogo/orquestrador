package com.cadastro.produto.controller;

import com.cadastro.produto.domain.ProdutoDomain;
import com.cadastro.produto.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produto")
@Slf4j
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<ProdutoDomain> lista(){
        log.info("ENDPOINTPRODUTO");
        return produtoRepository.findAll();
    }
}
