package com.cadastro.produto.repository;

import com.cadastro.produto.domain.ProdutoDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoDomain, Long> {
}
