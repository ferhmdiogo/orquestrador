package com.orquestrador.repository;

import com.orquestrador.repository.response.ProdutoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "produto", url = "http://localhost:8091/produto")
public interface ProdutoRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<ProdutoResponse> retornaProduto();
}
