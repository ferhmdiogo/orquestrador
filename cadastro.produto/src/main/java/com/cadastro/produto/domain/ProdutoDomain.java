package com.cadastro.produto.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;
    private Long usuarioId;
    private String nomeProduto;
    private String descricao;
}
